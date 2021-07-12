package com.everis.dar.discordjokebot.client;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import com.everis.dar.discordjokebot.model.JokeModel;

import reactor.core.publisher.Mono;

public class JokeClient {

	
	public String getJoke() {	
		
		WebClient webClient = WebClient.builder()
		        .baseUrl("https://v2.jokeapi.dev")
		        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
		        .build();
		
	    Mono<JokeModel> respuesta = webClient.get()
	            .uri("/joke/Programming?type=single")
	            .retrieve()
	            .bodyToMono(JokeModel.class);


		return respuesta.block().getJoke();
	}

}
