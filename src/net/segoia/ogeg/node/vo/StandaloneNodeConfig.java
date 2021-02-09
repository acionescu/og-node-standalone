package net.segoia.ogeg.node.vo;

import java.util.Map;

public class StandaloneNodeConfig {
    private String hostName = "0.0.0.0";
    private int port;
    private String webDir;

    private Map<String, String> systemConfigs;
    private Map<String, WebappConfig> apps;
    
    /**
     * SSL config
     */
    private int sslPort;
    private String keyStorePath;
    private String keyStorePass;
    private String keyStoreType;
    private String keyAlias;

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

    public int getSslPort() {
        return sslPort;
    }

    public void setSslPort(int sslPort) {
        this.sslPort = sslPort;
    }

    public String getKeyStorePath() {
        return keyStorePath;
    }

    public void setKeyStorePath(String keyStorePath) {
        this.keyStorePath = keyStorePath;
    }

    public String getKeyStorePass() {
        return keyStorePass;
    }

    public void setKeyStorePass(String keyStorePass) {
        this.keyStorePass = keyStorePass;
    }

    public String getKeyStoreType() {
        return keyStoreType;
    }

    public void setKeyStoreType(String keyStoreType) {
        this.keyStoreType = keyStoreType;
    }

    public String getKeyAlias() {
        return keyAlias;
    }

    public void setKeyAlias(String keyAlias) {
        this.keyAlias = keyAlias;
    }

}
