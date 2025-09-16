FROM eclipse-temurin:17
LABEL maintainer="Caio Victor"
WORKDIR /appmeetsync
COPY target/MeetSync-0.0.1-SNAPSHOT.jar appmeetsync/meet-sync-app.jar
ENTRYPOINT ["java", "-jar", "meet-sync-app.jar"]
