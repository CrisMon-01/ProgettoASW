#!/bin/bash

# itera la richiesta 10 volte 

for i in {1..10}; do
	sleep 3
	
	echo "Richiesta POST servizio A"
	curl -X POST localhost:8080/aservice
	echo "" 
	
	echo "Richiesta GET servizio A"
	curl localhost:8080/aservice
	echo ""
done 
