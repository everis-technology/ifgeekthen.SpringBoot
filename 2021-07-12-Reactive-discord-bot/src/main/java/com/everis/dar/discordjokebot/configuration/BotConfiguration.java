package com.everis.dar.discordjokebot.configuration;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.everis.dar.discordjokebot.client.JokeClient;
import com.everis.dar.discordjokebot.eventListener.EventListener;

import discord4j.core.DiscordClientBuilder;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.Event;

@Configuration
public class BotConfiguration {

    private static final Logger log = LoggerFactory.getLogger( BotConfiguration.class );

    @Value("${discord.token}")
    private String token;

    @Bean
    public <T extends Event> GatewayDiscordClient gatewayDiscordClient(List<EventListener<T>> eventListeners) {
        GatewayDiscordClient client = null;

        try {
            client = DiscordClientBuilder.create(token)
              .build()
              .login()
              .block();

            for(EventListener<T> listener : eventListeners) {
                client.getEventDispatcher().on(listener.getEventType())
                  .flatMap(listener::execute)
                  .onErrorResume(listener::handleError)
                  .subscribe(event -> {System.out.println("Event registered: " + listener.getEventType());});
            } 
            
            client.onDisconnect().block();
            
        }
        catch ( Exception exception ) {
            log.error( "Be sure to use a valid bot token!", exception );
        }

        return client;
    }
    
    
    @Bean
    public JokeClient jokeClient() {
    	return new JokeClient();
    }
}

