package net.segoia.ogeg.node;

public class NodeBootstrap {
    
    public static void main(String[] args) throws Exception{
	new StandaloneOgNode("test/node-config1.json").start();
//	Thread.sleep(5000);
//	new StandaloneOgNode("config/node-config2.json").start();
//	new StandaloneOgNode("test/node-config3.json").start();
    }

}
