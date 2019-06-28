#!/bin/bash

while true; do 
	sleep 3
	
	echo "Richiesta POST servizio A"
	curl -X POST localhost:8080/aservice
	echo "" 
	
	echo "Richiesta GET servizio A"
	curl localhost:8080/aservice
	echo ""
done 
