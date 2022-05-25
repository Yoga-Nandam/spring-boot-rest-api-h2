FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD target/spring-boot-rest-api-h2-0.0.1-SNAPSHOT.jar spring-boot-rest-api-h2-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["sh","-c","java -jar /spring-boot-rest-api-h2-0.0.1-SNAPSHOT.jar"]