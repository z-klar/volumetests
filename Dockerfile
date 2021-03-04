FROM openjdk:8-jre-alpine

ENV PROPERTIES_PATH src/main/resources/application-docker.properties

COPY build/libs/volumetests-0.1.jar /var/app.jar
COPY $PROPERTIES_PATH /cfg/application-docker.properties

ENTRYPOINT java -jar /var/app.jar --spring.config.location=/cfg/application-docker.properties
