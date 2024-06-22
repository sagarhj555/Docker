FROM openjdk
ADD target/DockerJavaProject.jar dockerproject.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/dockerproject.jar"]