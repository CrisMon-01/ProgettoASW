#!/bin/bash

echo SOURCE
source set-docker-host-ip.sh

#echo START KAFKA IN DOCKER
#sh start-kafka.sh

echo !!!BUILD!!!
cd eureka-server
gradle build
cd ..
cd servizioA
gradle build
cd ..
cd servizioB
gradle build
cd ..
cd servizioC
gradle build 
cd ..
cd zuul-gateway
gradle build 
cd ..

echo !!!DOCKER COMPOSE!!!
docker-compose up --build --scale servizioa=3 --scale servizioc=3 

#echo !!! ALL BUILD RUN APPLICATIONS !!!
#java -Xms64m -Xmx128m -jar eureka-server/build/libs/eureka-server.jar &
#java -Xms64m -Xmx128m -jar servizioA/build/libs/servizioA.jar &
#java -Xms64m -Xmx128m -jar servizioB/build/libs/servizioB.jar &
#java -Xms64m -Xmx128m -jar servizioC/build/libs/servizioC.jar &
#java -Xms64m -Xmx128m -jar zuul-gateway/build/libs/zuul-gateway.jar

echo !!! THE APPLICATION IS RUNNING !!!
