# Use an official Maven image as the base image
FROM maven:3.9-eclipse-temurin-17 AS build
# Set the working directory in the container
WORKDIR /app
# Copy the pom.xml and the project files to the container
COPY pom.xml .
COPY src ./src
# Build the application using Maven
RUN mvn clean package -DskipTests

# This image will not have the source nor maven, just the executable jar file
FROM eclipse-temurin:17-jdk
# Set the working directory in the container
WORKDIR /app
# Copy the built JAR file from the previous stage (build) to this container
COPY --from=build /app/target/syracuse.jar .

EXPOSE 8080

# Set the command to run the application
CMD ["java", "-jar", "syracuse.jar"]