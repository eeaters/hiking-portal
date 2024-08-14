FROM openjdk:23-ea-17-jdk-bullseye

WORKDIR /app

COPY target/hiking-portal.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]