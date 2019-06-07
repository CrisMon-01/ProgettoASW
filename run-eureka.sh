#!/bin/bash

echo Running SENTENCE [Eureka + Discovery Client]

echo Starting Eureka Server  
java -Xms64m -Xmx128m -jar eureka-server/build/libs/eureka.jar &

curl http://localhost:9090
