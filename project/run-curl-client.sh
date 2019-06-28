#!/bin/bash

# esegue POST e GET 

echo "Richiesta POST servizio A"
curl -X POST localhost:8080/aservice
echo "" 
	
echo "Richiesta GET servizio A"
curl localhost:8080/aservice
echo ""
