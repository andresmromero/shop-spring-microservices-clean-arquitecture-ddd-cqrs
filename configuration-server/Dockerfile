FROM openjdk:21-jdk-slim
RUN apt-get update && apt-get install -y curl
WORKDIR /app
COPY target/configuration-server-0.0.1-SNAPSHOT.jar configuration-server.jar
CMD ["java", "-jar", "configuration-server.jar"]