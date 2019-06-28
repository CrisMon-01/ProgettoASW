#!/bin/bash

echo SOURCE
source set-docker-host-ip.sh

echo --- BEGIN BUILD ---

gradle build

echo --- BUILD COMPLETE ---

echo --- DOCKER COMPOSE ---
docker-compose up --build --scale aservice=3 --scale bservice=3 --scale cservice=3
# docker-compose up --build -d --scale aservice=3 --scale bservice=3 --scale cservice=3 

echo --- THE APPLICATION IS RUNNING ---
