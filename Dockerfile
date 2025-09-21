# Use Gradle + JDK 17 for building
FROM gradle:8.3-jdk17 AS build

WORKDIR /app

# Copy project files
COPY . .

# Build the Spring Boot JAR (skip tests to speed up)
RUN gradle bootJar -x test

# Use a lightweight JDK for running
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the built JAR from the builder stage
COPY --from=build /app/build/libs/realestate-app.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
