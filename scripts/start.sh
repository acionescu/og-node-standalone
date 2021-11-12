#!/bin/bash
source conf.sh
$OGNODE_JAVA_HOME/bin/java -Dlog4j.configuration=file:config/log4j.properties -Djava.net.preferIPv4Stack=true -Djava.library.path=$CEF_BIN_DIR/lib/linux64 -cp libs/*:cef/libs/*:cef-node.jar net.segoia.ogeg.node.OgNodeStarter config/node-init.json