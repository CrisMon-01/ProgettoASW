########################################################
# Dockerfile per l'applicazione progettoASW / eureka server 
########################################################

FROM openjdk:8-jdk

ADD build/libs/eureka-server.jar eureka.jar

EXPOSE 8761

ENTRYPOINT ["java", "-Xmx128m", "-Xms128m", "-jar", "eureka.jar"]