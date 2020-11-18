#!/bin/bash
source conf.sh
java -Dlog4j.configuration=file:config/log4j.properties -Djava.net.preferIPv4Stack=true -cp libs/*:og-node.jar net.segoia.ogeg.node.OgNodeStarter config/node-init.json