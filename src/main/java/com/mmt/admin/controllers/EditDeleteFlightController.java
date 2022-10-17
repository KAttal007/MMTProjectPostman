package com.mmt.admin.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mmt.admin.exceptions.FlightIdNotFoundException;
import com.mmt.admin.exceptions.FlightNotDeletedException;
import com.mmt.admin.service.AdminServiceInterface;
import com.mmt.flights.model.Flight;
import com.mmt.flights.services.FlightServiceInterface;

@RestController
public class EditDeleteFlightController {
	@Autowired
	private AdminServiceInterface as;

	@Autowired
	private FlightServiceInterface fs;

	Logger logger = LoggerFactory.getLogger(EditDeleteFlightController.class);

	@ExceptionHandler(value = FlightIdNotFoundException.class)
	public ResponseEntity<Void> flightIdNotFoundExceptionHandler() {
		logger.error("Flight Not Found");
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = FlightNotDeletedException.class)
	public ResponseEntity<Flight> flightNotDeletedExceptionHandler(Model m) {

		logger.error("Flight Not Deleted");
		return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
	}

	@PutMapping("updateFlight") // -- updateFlightPage
	public ResponseEntity<Flight> updateFlight(@Valid @RequestBody Flight flight, BindingResult br, Model m)
			throws FlightIdNotFoundException {
		if (br.hasErrors())
			return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
		else {
			Flight updateFlight = as.updateFlight(flight);
			if (updateFlight != null) {
				return new ResponseEntity<Flight>(updateFlight, HttpStatus.ACCEPTED);
			}
			throw new FlightIdNotFoundException("Flight Not Found");
		}
	}

	@DeleteMapping("deleteFlight/{flightId}") // -- deleteFlightpage
	public ResponseEntity<Void> deleteFlight(@PathVariable("flightId") String flightId, Model m)
			throws FlightNotDeletedException {
		if (as.removeFlight(flightId)) {

			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		} else {
			throw new FlightNotDeletedException("Flight Not Deleted");
		}
	}
}
