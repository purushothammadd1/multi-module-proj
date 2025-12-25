FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY target/booking-service-1.0-SNAPSHOT.jar booking.jar

EXPOSE 9090

ENTRYPOINT ["java", "-jar", "booking.jar"]
