FROM amazoncorretto:22-alpine-jdk

WORKDIR /app

COPY target/hiking-portal.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]