FROM openjdk:21-jdk-slim
RUN apt-get update && apt-get install -y curl
WORKDIR /app
COPY target/discovery-server-0.0.1-SNAPSHOT.jar discovery-server.jar
CMD ["java", "-jar", "discovery-server.jar"]