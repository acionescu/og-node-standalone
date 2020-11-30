### Description

This is a standalone Open Groups node. It runs in an embedded Tomcat instance.
The webapp project can be found [here](https://github.com/acionescu/og-node).

This node can run on its own and can also connect to other nodes in a federalized network that allows the exchange of different services.

For now, a simple chat demo is implemented. Each server node can join the network and the clients connected to different nodes can talk to each other seamlessly.

### Installing the node

* Download the [current distribution](https://github.com/acionescu/og-node-standalone/dist/ognode-dist.zip)
* Unzip the archive to a preffered location

### Configuring the node

By default, this node will connect to the [main node](https://segoia.net/ognode).

To prevent it from joining the global network, or just make it connect to a custom network, edit the file `opengroups_node.json` as described below:

In the `agents` section, find the following block:

```json
"agent": {
						"className": "net.segoia.ogeg.services.core.agents.NodeInteroperabilityAgent",
						"config": {
							"upstreamNodes":[
								{
									"id": "mainNode",
									"nodeDef":{
										"uri":"wss://segoia.net/ognode/ws/v1/events",
										"channel":"WSS_V1"
									},
									"nodeSettings":{
										"autoConnect":true
									}
								}
								
							]
						}
					}

```

Set `autoConnect` to `false` or remove the `mainNode` definition altogether.

You can also specify a different node to connect to, or even more, if you want your node to act as a bridge.


### Running the node on Linux or other Unix operating systems

* Enter into the `ognode` directory that you unzipped earlier
* Run `./ognode-start.sh` - the process wil run in the background
* You can stop it with `./ognode-stop.sh`

### Running the node on Windows

* Install [Git Bash](https://www.stanleyulili.com/git/how-to-install-git-bash-on-windows/)
* Launch the Git Bash
* In the git bash window, follow the steps for the linux os, listed above


### Accessing the local node webapp

* Open the browser and enter the address <http://localhost:8185/og-node/>
* To access the chat demo directly, go to <http://localhost:8185/og-node/client/chat.html>

### Accessing the main node

* Open <https://segoia.net/ognode/>


