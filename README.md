# Progetto ASW 2018-2019

Progetto per il corso "Architettura dei Sistemi Software" a.a. 2018-2019. <br />

Versione progetto selezionata: 2D http://cabibbo.dia.uniroma3.it/asw/progetti/asw-progetto.pdf<br />

Membri:
* Baldazzi Teodoro;
* D'Agostino Fabiano;
* Monti Cristian.

## Ambiente di esecuzione 

L'applicazione è stata ideata per essere eseguita nell'ambiente [workstation](environments/workstation/), usando Vagrant. 
Vanno però utilizzate più finestre (terminali) diverse. In genere, una per l'applicazione e una per il suo client.
* Esecuzione ambiente [workstation](environments/workstation/):
```
    cd environments/workstation
    vagrant up
    vagrant ssh
```

## Esecuzione applicazione (dopo aver avviato ambiente [workstation](environments/workstation/))

Per semplificare l'esecuzione, è stato costruito lo script [build-and-run.sh](project/), che effettua
build e avvia l'applicazione con 3 istanze replicate per i servizi A, B e C. 
Pertanto risulta sufficiente:
```
    cd ../../project
    source set-docker-host-ip.sh
    sh build-and-run.sh
```

Qualora si volessero invece svolgere manualmente tutti i passi per l'esecuzione:
* Costruzione applicazione:
```
    cd ../../project
    sh build-project.sh
```
* Clean applicazione:
```
    sh clean-java-projects.sh
```
* Esecuzione applicazione:
```   
    source set-docker-host-ip.sh
    sh start-services.sh # singola istanza per ciascun servizio
    sh start-services-replicated.sh # più istanze per ciascun servizio
```
* Verifica applicazione
in pratica, l'applicazione può essere verificata usando lo script `` run-curl-client.sh ``, che effettua 10 POST e 10 GET, 
oppure `` run-curl-client-forever.sh `` (alla fine va arrestato con CTRL-C).

Alcune osservazioni: 
* le applicazioni funzionano correttamente anche in presenza di più istanze di ciascun servizio; visto il limitato
numero di nomi identificativi a disposizione per ciascuno, potrebbe verificarsi la ripetizione dello stesso nome per differenti
istanze di uno stesso servizio;
* in particolare in presenza di più istanze, potrebbe occorrere qualche minuto affinché siano tutte registrate correttamente.

## Arresto

Per arrestare l'applicazione, eseguire lo script `` stop-with-compose.sh ``.

