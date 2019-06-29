# Progetto ASW 2018-2019

Progetto per il corso "Architettura dei Sistemi Software" a.a. 2018-2019. <br />

Versione progetto selezionata: 2D. <br /> 
Riferimento specifiche e tecnologie adoperate: http://cabibbo.dia.uniroma3.it/asw/progetti/asw-progetto.pdf<br />

Membri:
* Baldazzi Teodoro;
* D'Agostino Fabiano;
* Monti Cristian.


## Esecuzione

I seguenti passi sono presentati assumendo che ci si trovi all'interno della cartella ProgettoASW.


### Ambiente di esecuzione 

L'applicazione è stata ideata per essere eseguita nell'ambiente [workstation](environments/workstation/), usando Vagrant. 
Vanno però utilizzate più finestre (terminali) diverse. In genere, una per l'applicazione e una per il suo client (ovvero aprire due connessioni ssh con la macchina virtuale ripetendo la procedura di ``` vagrant ssh ``` dalla cartella ``` ./environments/workstation/ ```).
* Esecuzione ambiente [workstation](environments/workstation/):
```
    cd environments/workstation
    vagrant up
    vagrant ssh
```


### Esecuzione applicazione (dopo aver avviato ambiente [workstation](environments/workstation/))

Per semplificare l'esecuzione, è stato costruito lo script [build-and-run.sh](project/), che effettua
build e avvia l'applicazione con 3 istanze replicate per i servizi A, B e C. 
Pertanto risulta sufficiente da uno dei due terminali eseguire:
```
    cd project
    source set-docker-host-ip.sh
    ./build-and-run.sh
```

Qualora si volessero invece svolgere manualmente tutti i passi per l'esecuzione:
* Costruzione applicazione:
```
    cd project
    ./build-projects.sh
```
* Clean applicazione (se necessario):
```
    ./clean-java-projects.sh
```
* Esecuzione applicazione:
```   
    source set-docker-host-ip.sh
    ./start-services.sh 	        # singola istanza per ciascun servizio
    ./start-services-replicated.sh      # più istanze per ciascun servizio
```

* Verifica applicazione (dall'altro terminale in ssh con la macchina virtuale: workstation)
in pratica, l'applicazione può essere verificata usando lo script `` run-curl-client.sh ``, che effettua il numero di POST e GET fornito in input o infinite (se si inserisce come input 0, nel quale caso alla fine va arrestato con CTRL-C).

Alcune osservazioni: 
* le applicazioni funzionano correttamente anche in presenza di più istanze di ciascun servizio; visto il limitato numero di nomi identificativi a disposizione per ciascuno, potrebbe verificarsi la ripetizione dello stesso nome per differenti istanze di uno stesso servizio;
* in particolare in presenza di più istanze, potrebbe occorrere qualche minuto, a partire dalla prima richiesta del client, affinchè siano tutte registrate correttamente: sino ad allora si verificherà 
`` ZuulException: Hystrix Readed time out ``. E' stato inoltre osservato che eseguire un elevato numero di richieste POST In tale intervallo di tempo possa causare che, nonostante l'eccezione sopra citata,
alcune di queste abbiano effettivamente successo.


### Arresto

Per arrestare l'applicazione, eseguire:
``` 
    ./stop-with-compose.sh 
```

