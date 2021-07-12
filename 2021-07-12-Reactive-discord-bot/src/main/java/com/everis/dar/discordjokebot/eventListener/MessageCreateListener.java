package com.everis.dar.discordjokebot.eventListener;

import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.dar.discordjokebot.client.JokeClient;

import reactor.core.publisher.Mono;

@Service
public class MessageCreateListener  implements EventListener<MessageCreateEvent> {
	
	@Autowired
	private JokeClient jokeClient;

    @Override
    public Class<MessageCreateEvent> getEventType() {
        return MessageCreateEvent.class;
    }

    @Override
    public Mono<Void> execute(MessageCreateEvent event) {
        return processCommand(event.getMessage());
    }
    
    
    private Mono<Void> processCommand(Message eventMessage) {
        return Mono.just(eventMessage)
           .filter(message -> (message.getContent().startsWith("!joke")))        		
           .filter(message -> message.getAuthor().map(user -> !user.isBot()).orElse(false))
           .flatMap(Message::getChannel)
           .flatMap(channel -> channel.createMessage(jokeClient.getJoke()))
           .then();
    }
}
