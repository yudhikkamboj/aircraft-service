#Runtime stage
FROM eclipse-temurin:21-jre
WORKDIR /app

COPY target/aircraft-service*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]