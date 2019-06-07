#!/bin/bash

echo Running SENTENCE [Eureka + Discovery Client]

echo Starting Eureka Server  
cd eureka-server
gradle build
cd ..
java -Xms64m -Xmx128m -jar eureka-server/build/libs/eureka.jar &

curl http://localhost:9090
