package com.everis.dar.springairline.model;

import java.util.HashMap;
import java.util.Map;

public class AircraftFleet {
	public Map<Long, Flight> fleet = new HashMap<Long, Flight>();

	
	public AircraftFleet() {
		
		Aircraft aircraft1 = new Aircraft("Airbus A350", 2018);
		Aircraft aircraft2 = new Aircraft("CRJ-1000", 2019);
		Aircraft aircraft3 = new Aircraft("Airbus A320", 2019);
		
		Map<String, Passenger> listPassenger1 = new HashMap<String, Passenger>();
		listPassenger1.put("00040601Y", new Passenger("00040601Y", "ANA", "LOPEZ LOPEZ"));
		listPassenger1.put("23574660M", new Passenger("23574660M", "MANUEL", "LOPEZ RUIZ"));
		listPassenger1.put("73800632A", new Passenger("73800632A", "CRISTINA", "LOIGORRI SANZ"));
		
		Map<String, Passenger> listPassenger2 = new HashMap<String, Passenger>();
		listPassenger2.put("14690202X", new Passenger("14690202X", "JUAN", "PEREZ GARCIA"));
		listPassenger2.put("73324262D", new Passenger("23574660M", "PLATON", "GONZALEZ CAMPO"));
		
		Map<String, Passenger> listPassenger3 = new HashMap<String, Passenger>();
		listPassenger3.put("60682560G", new Passenger("60682560G", "FERNANDO", "SOTOMAYOR GERRERI"));
		listPassenger3.put("35238923W", new Passenger("35238923W", "MERCHE", "GARCIA GIBERT"));		
		
		
		Flight flight1 = new Flight(aircraft1, Long.valueOf(1), "Madrid", "Buenos Aires", listPassenger1, "IN TIME");
		Flight flight2 = new Flight(aircraft2, Long.valueOf(2), "Valencia", "Dublin", listPassenger2, "CANCELED");
		Flight flight3 = new Flight(aircraft3, Long.valueOf(3), "Sevilla", "Madrid", listPassenger3, "DELAYED");
		
		this.fleet.put(Long.valueOf(1), flight1);
		this.fleet.put(Long.valueOf(2), flight2);
		this.fleet.put(Long.valueOf(3), flight3);
	}
	

	public Map<Long, Flight> getFleet() {
		return fleet;
	}

	public void setFleet(Map<Long, Flight> fleet) {
		this.fleet = fleet;
	}
	
}
