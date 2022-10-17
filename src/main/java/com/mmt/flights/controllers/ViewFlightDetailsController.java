package com.mmt.flights.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mmt.admin.exceptions.FlightIdNotFoundException;
import com.mmt.bookedFlight.model.BookedFlight;
import com.mmt.flights.exceptions.FlightSeatsNotAvailableException;
import com.mmt.flights.model.Flight;
import com.mmt.flights.services.FlightServiceInterface;
import com.mmt.user.exceptions.NoFlightBookingException;
import com.mmt.user.model.User;
import com.mmt.user.services.UserServiceInterface;

@RestController
public class ViewFlightDetailsController {
	@Autowired
	private FlightServiceInterface fs;
	@Autowired
	private UserServiceInterface us;
	
	Logger logger = LoggerFactory.getLogger(ViewFlightDetailsController.class);

	@ExceptionHandler(value = NoFlightBookingException.class)
	public ResponseEntity<Flight> noFlightBookingFoundExceptionHandler(Model m) {
		m.addAttribute("message", "No flight Found ");
		return new ResponseEntity<Flight>(HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = FlightSeatsNotAvailableException.class)
	public ResponseEntity<Flight> flightSeatsNAExceptionHandler(Model m)
	{
		m.addAttribute("message" , "No seat avilable");
		return new ResponseEntity<Flight>(HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(value = FlightIdNotFoundException.class)
	public ResponseEntity<Flight> flightIdNotFoundExceptionHandler(Model m)
	{
		m.addAttribute("message", "Flight Id Not Found");
		return new ResponseEntity<Flight>(HttpStatus.NOT_FOUND);
	}
	
	
	@GetMapping("viewFlightOne/{flightId}")
	public ResponseEntity<Flight> viewFlightOne(@PathVariable("flightId") String flightId , Model m) throws FlightIdNotFoundException{
		Flight flight =fs.viewFlightDetails(flightId);
		if(flight!=null)
		{
			m.addAttribute("FlightDetails" ,flight );
			return new ResponseEntity<Flight>(flight,HttpStatus.FOUND);
		}
		throw new FlightIdNotFoundException("Flight Not Found");
	}
	@GetMapping("checkAvailabilty/{flightId}/noOfSeats/{noOfSeats}")
	public ResponseEntity<Flight> checkAvailabilty(@PathVariable("flightId") String flightId , @PathVariable("noOfSeats") int noOfSeats, 
			HttpSession session , Model m) throws FlightSeatsNotAvailableException
	{
		String userId = (String) session.getAttribute("userId");
		if(userId==null) 
			return new ResponseEntity<Flight>(HttpStatus.UNAUTHORIZED);
		if(fs.isSeatsAvilable(flightId, noOfSeats)) {
			float price = fs.flightPrice(flightId, noOfSeats);
			session.setAttribute("noOfSeats" , noOfSeats);
			session.setAttribute("flightId" , flightId);
			session.setAttribute("price", price );
			return new ResponseEntity<Flight>(HttpStatus.CREATED);
		}
		logger.error("Seats "+noOfSeats+" wanting to be booked are more than seats currently available");
		throw new FlightSeatsNotAvailableException("Seats wanting to be booked are more than seats currently available");
	}
	@GetMapping("viewMyFlightBooking")
	public ResponseEntity<List<BookedFlight>> viewMyFlightBooking(Model m , HttpSession session) throws NoFlightBookingException {
		String userId = (String) session.getAttribute("userId");
		if (userId == null)
			return new ResponseEntity<List<BookedFlight>>(HttpStatus.FORBIDDEN);
		List<BookedFlight> flight = us.allBookedFlight(userId);
		if (flight.size() > 0) {
			m.addAttribute("list", flight);
			return new ResponseEntity<List<BookedFlight>>(flight,HttpStatus.FOUND);
		}
		logger.error("No Flights booked by user "+userId);
		throw new NoFlightBookingException("No Flight Booking by user ");
	}
}