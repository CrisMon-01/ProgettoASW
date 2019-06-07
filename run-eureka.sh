
#!/bin/bash

echo Running SENTENCE [Eureka + Discovery Client]

echo Starting Eureka Server  
java -Xms64m -Xmx128m -jar eureka-server/build/libs/eureka.jar &

#echo Starting Sentence Service [*1, using Discovery Client]

#java -Xms64m -Xmx128m -jar sentence-service/build/libs/sentence.jar &
