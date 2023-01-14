FROM openjdk:17

MAINTAINER EDS

COPY target/demo-0.0.1-SNAPSHOT.jar eds-app.jar

ENTRYPOINT ["java","-jar","/eds-app.jar"]
