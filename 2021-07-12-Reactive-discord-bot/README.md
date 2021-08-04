# Discord bot with Spring Boot and Reactive programming

Java project that shows how to create a chatbot for the Discord platform using Spring Boot, the Discord4j library and reactive programming

## Requirements

* Java 11
* It is recommended to have Docker installed on your computer. Visit [its official page][https://docs.docker.com/get-docker/]


## Execution

1. Access to https://discord.com/developers/applications
2. Using our discord profile create a new application, configure it as a bot and grant it the necessary permissions
3. Using the url provided by Discord install the bot on a server for which we have administrator permissions
4. Copy the authentication token in the application.properties file
5. Start the Spring Boot application and wait for it to connect successfully with Discord
6. On the server where the bot is installed, from a message channel invoke the bot using the configured command
