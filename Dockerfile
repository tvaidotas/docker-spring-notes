#FROM openjdk:8-jdk-alpine
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]

#---------------------------------------WIP

FROM maven:latest AS build
COPY . /build
WORKDIR /build
RUN mvn clean package

FROM openjdk:8-jdk-alpine AS run
WORKDIR /opt/hello-world
COPY --from=0 /build/target/*.jar app.jar
ENTRYPOINT ["/usr/bin/java", "-jar", "app.jar"]
