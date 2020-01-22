FROM maven:latest AS build
COPY . /build
WORKDIR /build
RUN mvn clean package

FROM openjdk:8-jdk-alpine AS run
WORKDIR /opt/notes
COPY --from=0 /build/target/*.jar app.jar
ENTRYPOINT ["/usr/bin/java", "-jar", "app.jar"]
