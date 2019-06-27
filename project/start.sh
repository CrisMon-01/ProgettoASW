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
docker-compose up --build --scale aservice=3 --scale bservice=3 --scale cservice=3
# docker-compose up --build -d --scale aservice=3 --scale bservice=3 --scale cservice=3 

echo --- THE APPLICATION IS RUNNING ---
