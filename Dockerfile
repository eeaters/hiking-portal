FROM openjdk:23-ea-22-windowsservercore-ltsc2022


WORKDIR /app

COPY target/hiking-portal.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]