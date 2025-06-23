# Use official Maven image to build the project
FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app
COPY . .

# Build the application
RUN mvn clean package -DskipTests

# Use a smaller JDK image for runtime
FROM eclipse-temurin:21-jdk

WORKDIR /app
COPY --from=build /app/target/user-service-0.0.1-SNAPSHOT.jar app.jar

# Expose the port
EXPOSE 8082

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
