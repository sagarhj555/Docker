---

# Dockerized Java Project

## Description

This project demonstrates how to build and containerize a Java application using Maven and Docker.

## Prerequisites

- JDK (Java Development Kit)
- Maven
- Docker

## Build the Project

First, build the project using Maven to create a JAR file of your application:

```sh
mvn clean package
```

This will generate the JAR file in the `target` directory.

## Create Dockerfile

Next, create a `Dockerfile` in the root directory of your project with the following contents:

```Dockerfile
FROM openjdk
ADD target/DockerJavaProject.jar dockerproject.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/dockerproject.jar"]
```

## Build Docker Image

Create a Docker image from the Dockerfile:

```sh
sudo docker buildx build -t dockerproject .
```

## Run Docker Container

Run the Docker image:

```sh
sudo docker run -p 8080:8080 dockerproject
```

## Congratulations

Your Dockerized Java application should now be running and accessible on port 8080.

---
