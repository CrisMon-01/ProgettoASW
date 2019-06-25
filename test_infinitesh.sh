#!/bin/bash

while true; do 
	sleep 3
	curl localhost:8080/aservice
	curl -X POST localhost:8080/aservice
	echo "" ; 
done 
