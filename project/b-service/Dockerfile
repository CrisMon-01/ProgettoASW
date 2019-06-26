###########################
# Dockerfile for b-service
###########################

FROM openjdk:8-jdk 

RUN apt-get update && apt-get install -y curl

ADD build/libs/b-service.jar b-service.jar

#EXPOSE 8081

ENTRYPOINT ["java", "-Xmx128m", "-Xms128m", "-jar", "b-service.jar"]

HEALTHCHECK --start-period=30s --interval=10s CMD curl -f http://localhost:8080/actuator/health || exit 1