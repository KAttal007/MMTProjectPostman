package com.mmt.flights.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mmt.bookedFlight.model.BookedFlight;
import com.mmt.flights.services.FlightServiceInterface;

import com.mmt.payment.CardDetails;




@RestController
public class BookFlightController {
	@Autowired
	private FlightServiceInterface fs;
	
	Logger logger = LoggerFactory.getLogger(BookFlightController.class);

	
	/*
	 * @RequestMapping("flightPaymentValidation") public String
	 * flightPaymentValidation(Model m) { m.addAttribute("card" , new
	 * CardDetails()); return "flightPaymentPage"; }
	 */
	
	
	@GetMapping("bookFlight") //-- bookFlightPage
	public ResponseEntity<BookedFlight> bookFlight(@Valid @RequestBody CardDetails card   ,BindingResult br,HttpSession session ) 
	{
		String userId = (String) session.getAttribute("userId");
		if(userId== null) 
		{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		if(br.hasErrors()) 
		{
			logger.error("Incorrect Card Details Entered by User"+userId);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		String flightId = (String) session.getAttribute("flightId");
		int noOfSeats = (int) session.getAttribute("noOfSeats");
		BookedFlight bfnew = fs.bookFlight(userId, flightId, noOfSeats); 
		session.removeAttribute("flightId");
		session.removeAttribute("noOfSeats");
		logger.info("User "+userId+" has booked Hotel "+flightId);
		return new ResponseEntity<BookedFlight>(HttpStatus.OK);
	}
}
