FROM eclipse-temurin:17-jdk-focal
 
ADD target/*.jar /app/rest-api-versioning-example.jar
WORKDIR /app
ENTRYPOINT ["java", "-jar", "rest-api-versioning-example.jar"]