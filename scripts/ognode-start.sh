#!/bin/bash
nohup ./start.sh >> ognode.out 2> ognode.err < /dev/null & jobPid=$!
echo $jobPid > ognode.pid
exit 0
