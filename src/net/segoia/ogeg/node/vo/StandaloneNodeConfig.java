/**
 * og-node-standalone - A basic Open Groups standalone node
 * Copyright (C) 2020  Adrian Cristian Ionescu - https://github.com/acionescu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
