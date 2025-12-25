FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY target/payment-service-1.0-SNAPSHOT.jar payment.jar

EXPOSE 9091

ENTRYPOINT ["java", "-jar", "payment.jar"]
