package com.everis.dar.springairline.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.everis.dar.springairline.model.AircraftFleet;

@Configuration
public class SpringAirlineConfiguration {
	
	@Bean
	public AircraftFleet aircraftFleet() {
		return new AircraftFleet();
	}
}
