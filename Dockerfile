FROM openjdk:17-jdk-slim

COPY /GigaMusicBE/target/*.jar /app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]