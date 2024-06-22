---

# Dockerized Multi-Container Java Project

## Description

This project demonstrates how to build and containerize a Java Spring Boot application using Maven and Docker, and how to set up a multi-container environment using Docker Compose with a PostgreSQL database.

## Prerequisites

- JDK (Java Development Kit)
- Maven
- Docker
- Docker Compose

## Build the Project

First, build the project using Maven to create a JAR file of your application:

```sh
mvn clean package
```

This will generate the JAR file in the `target` directory.

## Create Dockerfile

Next, create a `Dockerfile` in the `target` directory with the following contents:

```Dockerfile
FROM openjdk
ADD target/DockerMultiContainer.jar dockermulticontainer.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/dockermulticontainer.jar"]
```

## Create Docker Compose File

Create a `docker-compose.yml` file in the root directory of your project with the following contents:

```yaml
version: '3.7'

networks:
  multi-network:

services:
  image:
    container_name: docker-app
    build: .
    ports:
      - "8080:8080"
    environment:
      - SPRING_DATASOURCE_URL=jdbc:postgresql://postgres-db:5432/postgres
      - SPRING_DATASOURCE_USERNAME=sagar
      - SPRING_DATASOURCE_PASSWORD=1234
    depends_on:
      - postgres-db
    networks:
      - multi-network

  postgres-db:
    image: postgres:latest
    container_name: db-container
    ports:
      - "5433:5432"
    environment:
      - POSTGRES_DB=postgres
      - POSTGRES_USER=sagar
      - POSTGRES_PASSWORD=1234
    volumes:
      - postgres-data:/var/lib/postgresql/data
    networks:
      - multi-network

volumes:
  postgres-data:


```

## Update Application Properties

Make the necessary changes in your `application.properties` file to connect to the `postgres-db` container. It should look something like this:

```properties
spring.datasource.url=jdbc:postgresql://postgres-db:5433/postgres
spring.datasource.username=sagar
spring.datasource.password=1234
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

## Build and Run Containers

Go to the terminal and run:

```sh
sudo docker-compose up --build
```

## Congratulations

Your Dockerized multi-container Java application should now be running and accessible on port 8080, with PostgreSQL running on port 5433.

---
