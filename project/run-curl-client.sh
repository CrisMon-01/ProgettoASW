#!/bin/bash

# script per POST e GET client

FILE_NAME=$0
if [ $# != 1 ]
then
    echo "Utilizzo: $FILE_NAME <numero_richieste>" 
    echo "Se numero_richieste è pari a 0, il client effettua un numero infinito di richieste"
    exit 1
fi

function richiesta {
	echo "Richiesta POST servizio A"
    curl -X POST localhost:8080/aservice
    echo ""
	echo "Richiesta GET servizio A"
	curl localhost:8080/aservice
	echo ""
}

REQUESTS=$1

if [ $REQUESTS == 0 ]
then
    while true; do
		sleep 3
        richiesta
    done
else
    for i in $(eval echo {1..$REQUESTS}); do
		sleep 3
		richiesta
    done
fi