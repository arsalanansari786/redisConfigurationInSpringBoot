Prequisites ---

Java - 17
SpringBoot - 3.4.2
redis - 3.4.3
jedis - 5.2.0

My ip - 192.168.8.143
Remote Systems Ip - 192.168.8.124

Overview -
1- Made Single localhost database Connection 
2- Made  One Single and One remote Database Connection
3- Made single localhost pub and Sub connection on channel - "channel1"
4- Made one pubsub connection on localhost and one on remoteServer - for locahost channel - "channel1" and for remote channel - "cannel2"
5- localhost - 192.168.8.143
6- remote server - 192.168.8.124

Note - If remote host is not connecting then make sure redis server on remote host is enable to accept remoteConnections.If not type the below commands on linux - 
--> sudo nano /etc/redis/redis.conf
--> find this - bind 127.0.0.1 and change it to - bind 0.0.0.0
--> find this - protected-mode yes  and change it to- protected-mode no
--> sudo systemctl restart redis
Usign this we can als do redis streams and use redis as cache. It depend upon us how we want to use 


2 Dependency we need to use Redis - 
1- "<dependency>
			<groupId>org.springframework.data</groupId>
			<artifactId>spring-data-redis</artifactId>
			<version>3.4.3</version>
		</dependency>"
2- 	"<dependency>
			<groupId>redis.clients</groupId>
			<artifactId>jedis</artifactId>
			<version>5.2.0</version>
		</dependency>"
