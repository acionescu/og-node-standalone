#!/bin/bash
pidFile="ognode.pid"
if [ -f "$pidFile" ]
then
pid=`cat $pidFile`
echo "killing old process $pid"

#kill old process
	pkill -P $pid
#wait for the process to die
	wait $pid > /dev/null 2>&1
#remove old pid file
	rm $pidFile
fi
