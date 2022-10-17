package com.mmt.flights.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mmt.flights.exceptions.FlightNotFoundForSourceToDestinationException;
import com.mmt.flights.model.Flight;
import com.mmt.flights.services.FlightServiceInterface;
@RestController
public class ViewFlightsController {
	
	@Autowired
	private FlightServiceInterface fs;
	
	Logger logger = LoggerFactory.getLogger(ViewFlightsController.class);

	@ExceptionHandler(value = FlightNotFoundForSourceToDestinationException.class)
	public ResponseEntity<List<Flight>> FlightNotFoundForSourceToDestinationException(Model m) {
		return new ResponseEntity<List<Flight>>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("viewFlightSourceToDestination/from/{source}/to/{destination}")
	public ResponseEntity<List<Flight>> sourceToDestinationFlight(@PathVariable("source") String source,
			@PathVariable("destination") String destination, Model m) throws FlightNotFoundForSourceToDestinationException 
	{
		List<Flight> list = fs.flightFromStartCityToDestinationCityInOrder(source, destination);
		if (list.size() > 0) {
			m.addAttribute("flightList", list);
			return new ResponseEntity<List<Flight>>(list,HttpStatus.OK);
		}
		logger.error("No Flight from source "+source+ " to destination "+destination);
		throw new FlightNotFoundForSourceToDestinationException("Error 404. No Flight Found");
	}

	@GetMapping("checkFlight/{flightId}")
	public ResponseEntity<Flight> checkFlight(@PathVariable("flightId") String flightId, Model m) {
		Flight flight = fs.viewFlightDetails(flightId);
		m.addAttribute("flight", flight);
		return new ResponseEntity<Flight>(flight,HttpStatus.OK);
	}
}
