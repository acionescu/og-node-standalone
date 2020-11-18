package net.segoia.ogeg.node.vo;

import java.util.Map;

public class StandaloneNodeConfig {
    private String hostName = "0.0.0.0";
    private int port;
    private String webDir;

    private Map<String, String> systemConfigs;
    private Map<String, WebappConfig> apps;

    public String getHostName() {
	return hostName;
    }

    public void setHostName(String hostName) {
	this.hostName = hostName;
    }

    public int getPort() {
	return port;
    }

    public void setPort(int port) {
	this.port = port;
    }

    public String getWebDir() {
	return webDir;
    }

    public void setWebDir(String webDir) {
	this.webDir = webDir;
    }

    public Map<String, String> getSystemConfigs() {
	return systemConfigs;
    }

    public void setSystemConfigs(Map<String, String> systemConfigs) {
	this.systemConfigs = systemConfigs;
    }

    public Map<String, WebappConfig> getApps() {
	return apps;
    }

    public void setApps(Map<String, WebappConfig> apps) {
	this.apps = apps;
    }

}
