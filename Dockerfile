FROM eclipse-temurin:17-jdk-alpine
ADD target/arthouse-serv-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Dspring.profiles.active=homol", "-jar", "/app.jar"]