package com.everis.dar.springairline.rest;

import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.asm.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.everis.dar.springairline.model.AircraftFleet;
import com.everis.dar.springairline.model.Flight;
import com.everis.dar.springairline.model.Passenger;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name="FlightsRestService", description="The Flights api")
public class FlightsRestService {

	Logger logger = LoggerFactory.getLogger(FlightsRestService.class);

	@Autowired
	private AircraftFleet aircraftFleet;

	@Operation(summary = "Welcome", description = "Welcome to Spring Airlines", tags = { "FlightsRestService" })
	@GetMapping(value = "/welcome")
	public @ResponseBody String welcome() {
		logger.debug("Rest service: /welcome");

		return "***** WELCOME TO SPRING AIRLINES *****";
	}

	@Operation(summary = "Info", description = "Flight info", tags = { "FlightsRestService" })
	@GetMapping("/info/{id}")
	public @ResponseBody String getfligthInfo(
			@Parameter(description="Flight id", required = true, example="1", in = ParameterIn.PATH) @PathVariable(value = "id") Long id) {
		logger.debug("Rest service: /info/" + id);

		String info;

		try {
			info = aircraftFleet.getFleet().get(id).getFligthInfo();
		} catch (Exception e) {
			logger.error("ERROR finding flight");
			info = "Wrong flight id";
		}

		return info;
	}

	@Operation(summary = "Passenger info", description = "Get the passengers info through their id", tags = { "FlightsRestService" })
	@PostMapping("/passenger")
	public @ResponseBody String postPassenger(
			@Parameter(description="Passenger id", required = true, example="23574660M", in = ParameterIn.QUERY ) @RequestParam(name = "id") String id) {
		logger.debug("Rest service: /user/" + id);

		try {

			for (Entry<Long, Flight> entry : aircraftFleet.getFleet().entrySet()) {
				Map<String, Passenger> passengers = entry.getValue().getPassengers();
				Passenger passenger = passengers.get(id);

				if (passenger != null) {
					return entry.getValue().getFligthInfo() + "\n" + passenger.passengerInfo();
				}
			}

		} catch (Exception e) {
			logger.error("Error finding passenger with id " + id);
		}

		return "Passenger not finded";
	}

	@Operation(summary = "Add passenger", description = "Add a passenger in an exists flight", tags = { "FlightsRestService" })
	@PutMapping(path = "/addpassenger")
	public String putPassenger(
			@Parameter(description="Flight id", required = true, example="1", in = ParameterIn.QUERY ) @RequestParam(name = "fid") Long fid, 
			@Parameter(description="Passenger id", required = true, example="27089437Z", in = ParameterIn.QUERY ) @RequestParam(name = "pid") String pid,
			@Parameter(description="Passenger name", required = true, example="Roberto", in = ParameterIn.QUERY ) @RequestParam(name = "name") String name, 
			@Parameter(description="Passenger surname", required = true, example="Maldomingo Fasch", in = ParameterIn.QUERY ) @RequestParam(name = "surname") String surname) {
		logger.debug("Rest service: /addUser");
		
		String addUserInfo;

		try {
			Passenger passenger = new Passenger(pid, name, surname);
			aircraftFleet.getFleet().get(fid).getPassengers().put(pid, passenger);
			
			if(aircraftFleet.getFleet().get(fid).getPassengers().get(pid)==null) {
				logger.error("ERROR adding passenger with id " + pid + " in flight " + fid);
				addUserInfo = "Add passenger: ERROR";
			}
			else {
				addUserInfo = "Add passenger: OK";
			}
		}
		catch (Exception e) {
			logger.error("ERROR adding passenger with id " + pid + " in flight " + fid);
			addUserInfo = "Add passenger: ERROR";
		}
		
		return addUserInfo;
	}

	@Operation(summary = "Delete flight", description = "Delete an exists flight", tags = { "FlightsRestService" })
	@DeleteMapping(value = "/delflight/{id}")
	public String deleteFlight(
			@Parameter(description="Flight id", required = true, example="2", in = ParameterIn.PATH ) @PathVariable Long id) {
		
		String deleteInfo;
		
		try {
			aircraftFleet.getFleet().remove(id);
			
			if(aircraftFleet.getFleet().get(id)!=null) {
				logger.error("ERROR deleting flight with id " + id);
				deleteInfo = "Remove Flight: ERROR";
			}
			else {
				deleteInfo = "Remove Flight: OK";
			}
			
		}catch (Exception e) {
			logger.error("ERROR deleting flight with id " + id);
			deleteInfo = "Remove Flight: ERROR";
		}
		
		return deleteInfo;
	}
}