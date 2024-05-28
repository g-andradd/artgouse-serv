FROM openjdk:17
ADD target/arthouse-serv-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8050
ENTRYPOINT ["java", "-Dspring.profiles.active=homol", "-jar", "/app.jar"]