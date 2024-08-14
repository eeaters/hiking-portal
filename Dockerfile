FROM openjdk:22-jdk-slim-buster

WORKDIR /app

COPY target/hiking-portal.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]