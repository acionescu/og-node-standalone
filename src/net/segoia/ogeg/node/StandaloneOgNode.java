package net.segoia.ogeg.node;

import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Map;

import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardHost;
import org.apache.catalina.startup.ContextConfig;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.startup.VersionLoggerListener;
import org.apache.coyote.AbstractProtocol;

import com.google.gson.Gson;

import net.segoia.ogeg.node.vo.StandaloneNodeConfig;
import net.segoia.ogeg.node.vo.WebappConfig;

public class StandaloneOgNode {
    private StandaloneNodeConfig config;
    private boolean running;
    private Gson gson = new Gson();

    public StandaloneOgNode() {
	super();
    }

    public StandaloneOgNode(String configFile) {
	super();
	File cfgFile = new File(configFile);

	Reader fileReader = null;

	if (!cfgFile.exists()) {
	    /* look in classpath */
	    System.out.println("Using config file " + configFile + " from classpath");
//	    cfgFile = new File(this.getClass().getClassLoader().getResource(configFile).getFile());
	    InputStream resourceAsStream = this.getClass().getResourceAsStream(configFile);
	    if (resourceAsStream != null) {
		fileReader = new InputStreamReader(resourceAsStream);
	    }

	} else if (cfgFile.exists()) {

	    try {
		fileReader = new FileReader(cfgFile);

	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}

	if (fileReader != null) {
	    System.out.println("Parsing config file");
	    this.config = gson.fromJson(fileReader, StandaloneNodeConfig.class);
	} else {
	    throw new RuntimeException("Config file " + configFile + " was not found.");
	}
    }

    public StandaloneOgNode(StandaloneNodeConfig config) {
	super();
	this.config = config;
    }

    public void start() throws Exception {
	if (config == null) {
	    throw new IllegalStateException("No config is defined");
	}

	if (running) {
	    throw new IllegalStateException("Node already running with config " + gson.toJson(config));
	}
	init();
	running = true;
    }

    private void init() throws Exception {
	
	/* make sure the target webdire exists */
	File webDirFile = new File(config.getWebDir(),"webapps");
	if(!webDirFile.exists()) {
	    System.out.println("Creating webdir path "+config.getWebDir());
	    webDirFile.mkdirs();
	}
	
	Tomcat tomcat = new Tomcat();
	System.out.println("Starting Tomcat on host "+config.getHostName()+" port "+config.getPort());
	StandardHost host = new StandardHost();
	host.setName(config.getHostName());

	tomcat.setHostname(config.getHostName());
	tomcat.setPort(config.getPort());
	tomcat.setBaseDir(config.getWebDir());

	Connector connector = new Connector("HTTP/1.1");
	connector.setPort(config.getPort());
	connector.setProperty("address", config.getHostName());

	System.out.println(tomcat.getHost());
	
	setupSSL(tomcat);

	tomcat.getServer().addLifecycleListener(new VersionLoggerListener()); // nice to have

	// This magic line makes Tomcat look for WAR files in catalinaHome/webapps
	// and automatically deploy them
//	tomcat.getHost().addLifecycleListener(new HostConfig());

	// configure the server
	// configure web applications

	Map<String, String> systemConfigs = config.getSystemConfigs();
	if (systemConfigs != null) {
	    for (String key : systemConfigs.keySet()) {
		System.setProperty(key, systemConfigs.get(key));
	    }
	}

	tomcat.start();

	String currentDir = System.getProperty("user.dir");
	System.out.println("Current dir: "+currentDir);
	
	Map<String, WebappConfig> apps = config.getApps();
	if (apps != null) {
	    for (String key : apps.keySet()) {
		WebappConfig app = apps.get(key);
		tomcat.addWebapp(key, currentDir+File.separator+app.getDocBase());
	    }
	}

	tomcat.getServer().await();
    }
    
    private void setupSSL(Tomcat tomcat) {
	String keyStorePath = config.getKeyStorePath();
	if(keyStorePath == null) {
	    /* ssl is not supported */
	    return;
	}
	Connector sslConnector = new Connector();
	sslConnector.setPort(config.getSslPort());
	sslConnector.setSecure(true);
	sslConnector.setScheme("https");
	
	sslConnector.setAttribute("keyAlias", config.getKeyAlias());
	sslConnector.setAttribute("keystorePass", config.getKeyStorePass());
	sslConnector.setAttribute("keystoreFile", keyStorePath);
	sslConnector.setAttribute("clientAuth", "false");
	sslConnector.setAttribute("sslProtocol", "TLS");
	sslConnector.setAttribute("SSLEnabled", true);
	
	System.out.println("Adding ssl connector on port "+config.getSslPort());
	tomcat.getService().addConnector(sslConnector);
    }
}
