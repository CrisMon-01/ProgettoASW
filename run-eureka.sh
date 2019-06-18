#!/bin/bash

echo Running SENTENCE [Eureka + Discovery Client]

echo Starting Eureka Server  

gradle build

java -Xms64m -Xmx128m -jar eureka-server/build/libs/eureka-server.jar &
 
java -Xms64m -Xmx128m -jar servizioA/build/libs/servizioA.jar &
#curl http://localhost:9090

######################################
#NON SERVE + SOSTITUITO DA STARTUP.SH
#####################################
