#######################################################
# Dockerfile per l'applicazione progettoASW / servizio C 
#######################################################

FROM openjdk:8-jdk 

RUN apt-get update && apt-get install -y curl

ADD build/libs/servizioC.jar servizioC.jar

EXPOSE 8080

ENTRYPOINT ["java", "-Xmx128m", "-Xms128m", "-jar", "servizioC.jar"]

#HEALTHCHECK --start-period=30s --interval=10s CMD curl -f http://localhost:8080/actuator/health || exit 1