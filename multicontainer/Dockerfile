FROM openjdk
ADD target/DockerMultiContainer.jar dockermulticontainer.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/dockermulticontainer.jar"]