FROM eclipse-temurin:17-jdk-alpine
COPY target/spring-boot-docker.jar spring-boot-docker.jar
EXPOSE 8080
CMD ["java","-jar","spring-boot-docker.jar"]