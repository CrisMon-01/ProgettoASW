#######################################################
# Dockerfile per l'applicazione progettoASW / servizioB 
#######################################################

FROM openjdk:8-jdk 

RUN apt-get update && apt-get install -y curl

ADD build/libs/servizioB.jar servizioB.jar

EXPOSE 8080	#ports 8081:8080

ENTRYPOINT ["java", "-Xmx128m", "-Xms128m", "-jar", "servizioB.jar"]

#HEALTHCHECK --start-period=30s --interval=10s CMD curl -f http://localhost:8080/actuator/health || exit 1