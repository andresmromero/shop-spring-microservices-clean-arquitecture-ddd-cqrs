FROM openjdk:21-jdk-slim
RUN apt-get update && apt-get install -y curl
WORKDIR /app
COPY target/gateway-0.0.1-SNAPSHOT.jar gateway.jar
CMD ["java", "-jar", "gateway.jar"]