package com.everis.dar.springairline.model;

import java.util.HashMap;
import java.util.Map;


public class Flight {
	private Aircraft aircraft;
	private Long flightCode;
	private String origin;
	private String destiny;
	private String info;
	private Map<String, Passenger> passengers = new HashMap<String, Passenger>();

	public Flight(Aircraft aircraft, Long flightCode, String origin, String destiny, Map<String, Passenger> passengers,
			String info) {
		this.aircraft = aircraft;
		this.flightCode = flightCode;
		this.origin = origin;
		this.destiny = destiny;
		this.passengers = new HashMap<String, Passenger>(passengers);
		this.info = info;
	}

	public Long getFlightCode() {
		return flightCode;
	}

	public void setFlightCode(Long flightCode) {
		this.flightCode = flightCode;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestiny() {
		return destiny;
	}

	public void setDestiny(String destiny) {
		this.destiny = destiny;
	}

	public Aircraft getAircraft() {
		return aircraft;
	}

	public void setAircraft(Aircraft aircraft) {
		this.aircraft = aircraft;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Map<String, Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(Map<String, Passenger> passengers) {
		this.passengers = passengers;
	}
	
	
	public String getFligthInfo() {
		return "FLIGHT: " + flightCode + " " + origin + "----->" + destiny + " ("+info+")";
	}

}
