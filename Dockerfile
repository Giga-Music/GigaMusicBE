FROM maven:3.6.3-openjdk-17-slim AS build
COPY src /src
COPY pom.xml /
RUN mvn -f /pom.xml clean package -Dmaven.test.skip=true

FROM openjdk:17-jdk-slim
COPY --from=build /target/*.jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]