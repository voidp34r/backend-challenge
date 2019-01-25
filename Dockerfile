# FROM openjdk:8-jdk-alpine as build
# VOLUME /tmp
# WORKDIR /workspace/app

# COPY mvnw .
# COPY .mvn .mvn
# COPY pom.xml .
# COPY src src

FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE

COPY target/*.jar app.jar
# COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=docker","/app.jar"]
EXPOSE 8080 80