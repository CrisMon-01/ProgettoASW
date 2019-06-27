#!/bin/bash

# itera la richiesta 10 volte 

for i in {1..10}; do
	sleep 3
	curl localhost:8080/aservice
	curl -X POST localhost:8080/aservice
	echo "" ; 
done 
