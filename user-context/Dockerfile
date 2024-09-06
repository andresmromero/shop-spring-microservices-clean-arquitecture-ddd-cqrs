FROM openjdk:21-jdk-slim
RUN apt-get update && apt-get install -y curl
WORKDIR /app
COPY target/user-context-0.0.1-SNAPSHOT.jar user-context.jar
ENTRYPOINT ["java", "-jar", "user-context.jar"]