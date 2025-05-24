FROM openjdk:17-jdk-alpine

# 2. Set environment variables (optional)
#ENV APP_HOME=/usr/src/app

COPY ./devutility/target/Utility-0.0.1-SNAPSHOT.jar /app/Utility-0.0.1-SNAPSHOT.jar
# 3. Set the working directory
WORKDIR /app

# 4. Copy application files


# 5. (Optional) Run any build steps, e.g., Maven or Gradle
# RUN ./mvnw package

# 6. Expose the port your app runs on (optional)
EXPOSE 8080

# 7. Command to run the application
# Example for a Spring Boot jar:
ENTRYPOINT ["java", "-jar", "Utility-0.0.1-SNAPSHOT.jar"]
CMD ["--server.port=8080"]
