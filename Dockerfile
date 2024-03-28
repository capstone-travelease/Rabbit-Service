FROM openjdk:21

VOLUME /tmp

COPY target/*.jar RabbitService-0.0.1-SNAPSHOT.jar

EXPOSE 8082
ENTRYPOINT ["java","-jar","/RabbitService-0.0.1-SNAPSHOT.jar"]