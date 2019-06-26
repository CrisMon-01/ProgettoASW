#!/bin/bash

echo SOURCE
source set-docker-host-ip.sh

echo --- BEGIN BUILD ---

echo BUILD EUREKA
cd eureka-server
gradle build
cd ..

echo BUILD A-SERVICE
cd a-service
gradle build
cd ..

echo BUILD B-SERVICE
cd b-service
gradle build
cd ..

echo BUILD C-SERVICE
cd c-service
gradle build
cd ..

echo BUILD ZUUL-GATEWAY
cd zuul-gateway
gradle build 
cd ..

echo --- BUILD COMPLETE ---

echo --- DOCKER COMPOSE ---
docker-compose up --build -d --scale aservice=2 --scale bservice=2 --scale cservice=2 

echo --- THE APPLICATION IS RUNNING ---
