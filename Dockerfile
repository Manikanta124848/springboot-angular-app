# Use OpenJDK 17 slim image
FROM openjdk:17-jdk-slim

# Set working directory inside the container
WORKDIR /app

# Copy the built JAR into the container
COPY build/libs/realestate-app.jar app.jar

# Expose Spring Boot default port
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
