#!/bin/bash
/app/readhistory/start.sh
sleep 1;
/app/alertcenter/start.sh
sleep 1;
/app/accesshttp/start.sh
sleep 1;
/app/accessws/start.sh
sleep 1;
/app/matchengine/start.sh
sleep 3;
/app/marketprice/start.sh
sleep 3;
tail -f /dev/null