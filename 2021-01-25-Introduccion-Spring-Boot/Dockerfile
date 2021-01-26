FROM openjdk:11-jre-slim
ARG JAR_FILE=target/spring-airline-1.0.0.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]