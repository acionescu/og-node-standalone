package net.segoia.ogeg.node;

public class OgNodeStarter {

    public static void main(String[] args) throws Exception {
	String configFile ="/node-init.json";
	if(args.length > 0) {
	    configFile=args[0];
	}
	
	new StandaloneOgNode(configFile).start();
    }
}
