# kill chrome
ps -ef|grep chrome|grep -v grep|cut -c 9-15|xargs kill -9
