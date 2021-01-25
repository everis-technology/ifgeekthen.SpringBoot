# First steps with Spring Boot

Java project showing how to create and publish a REST api based on Spring Boot. This project is aimed at those people who want to get into Spring Boot technology and need a functional microservice as an example.

### Requirements

* Java 11
* It is recommended to have Docker installed on your computer. Visit [its official page][https://docs.docker.com/get-docker/]


### Execution

**With swagger-ui**

Once started, access the url **http://localhost:8085/airline/swagger-ui/index.html** and check *Explore* has as value **/airline/v3/api-docs**

**With curl**

| Operation  | Command  |
|---|---|
| GET | curl -X GET http://localhost:8085/airline/welcome |
| GET | curl -X GET http://localhost:8085/airline/info/1 |
| POST | curl -d "id=23574660M" -X POST http://localhost:8085/airline/passenger |
| PUT | curl -d "fid=1&pid=27089437Z&name=Roberto&surname=Maldomingo Fasch" -X PUT http://localhost:8085/airline/addpassenger |
| DELETE | curl -X DELETE http://localhost:8085/airline/delflight/2 |

### Build and start the Docker container

1. Build the docker image with name springairline: **docker build -t springairline .**

2. Run the docker image and expose in the port 8080 of the local machine the port 8085 of the docker image: **docker run -p 8080:8085 springairline**

