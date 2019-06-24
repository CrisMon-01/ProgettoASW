#######################################################
# Dockerfile per l'applicazione progettoASW / zuul 
#######################################################

FROM openjdk:8-jdk 

RUN apt-get update && apt-get install -y curl

ADD build/libs/zuul-gateway.jar zuul-gateway.jar

EXPOSE 8080

ENTRYPOINT ["java", "-Xmx128m", "-Xms128m", "-jar", "zuul-gateway.jar"]

#HEALTHCHECK --start-period=30s --interval=10s CMD curl -f http://localhost:8080/actuator/health || exit 1