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
docker-compose up --build -d --scale servizioa=3 --scale serviziob=3 --scale servizioc=3 

echo !!! THE APPLICATION IS RUNNING !!!
