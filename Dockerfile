FROM openjdk:latest
EXPOSE 8080
WORKDIR /app
COPY target/task-0.0.1-SNAPSHOT.jar target/task-0.0.1-SNAPSHOT.jar
# Run the jar file
CMD ["java","-jar","target/task-0.0.1-SNAPSHOT.jar"]