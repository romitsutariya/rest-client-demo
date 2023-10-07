FROM openjdk:11-jre-slim

RUN apt update && apt install -y openjdk-11-jdk

WORKDIR /app

COPY build/libs/rest-client-demo-0.0.1-SNAPSHOT.jar /app/spring-boot.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/spring-boot.jar"]