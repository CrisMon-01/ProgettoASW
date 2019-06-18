#!/bin/bashi

echo !!! BUILD !!!
echo BUILD EUREKA
cd eureka-server
gradle build
cd ..
echo BUILD SERVIZIO A
cd servizioA
gradle build
cd ..
echo BUILD SERVIZIO B
cd servizioB
gradle build
cd ..
#echo BUILD SERVIZIO C
#cd servizioC
#gradle build
#cd ..
echo !!! BUILD COMPLETE !!!
echo START APPLICAZIONE
docker-compose up -d
