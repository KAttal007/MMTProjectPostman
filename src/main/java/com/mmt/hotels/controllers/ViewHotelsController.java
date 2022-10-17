package com.mmt.hotels.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mmt.bookedHotel.model.BookedHotel;
import com.mmt.hotels.exceptions.HotelNotFoundException;
import com.mmt.hotels.model.Hotel;
import com.mmt.hotels.services.HotelServiceInterface;
import com.mmt.user.exceptions.NoHotelBookingFoundException;
import com.mmt.user.services.UserServiceInterface;

@RestController
public class ViewHotelsController {
	@Autowired
	private HotelServiceInterface hs;
	@Autowired
	private UserServiceInterface us;

	Logger logger = LoggerFactory.getLogger(ViewHotelsController.class);

	@ExceptionHandler(value = HotelNotFoundException.class)
	public ResponseEntity<Void> hotelNotFoundExceptionHandler() {
		logger.error("no hotel found at destination");
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = NoHotelBookingFoundException.class)
	public ResponseEntity<Void> noHotelBookingByUserExceptionHandler() {
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("viewHotel") // -- viewHotelpage
	public ResponseEntity<List<Hotel>> viewHotel(Model m) {
		List<Hotel> hotel = hs.allHotels();
		return new ResponseEntity<List<Hotel>>(hotel, HttpStatus.FOUND);
	}

	@GetMapping("viewHotelAtDestination/{search}") // -- viewHotelpage
	public ResponseEntity<List<Hotel>> viewHotelAtDestination(@PathVariable("search") String destination, Model m)
			throws HotelNotFoundException {
		List<Hotel> hotel = hs.hotelAtDestinationCity(destination);
		if (hotel.size() > 0) {
			m.addAttribute("hotelList", hs.hotelAtDestinationCity(destination));
			return new ResponseEntity<List<Hotel>>(hotel, HttpStatus.FOUND);
		} else {
			logger.error("No Hotel Found At Destination " + destination);
			throw new HotelNotFoundException("Error: 404. No Hotel Found At Destination");
		}
	}

	@GetMapping("viewMyHotelBooking")
	public ResponseEntity<List<BookedHotel>> viewMyHotelBooking(HttpSession session)
			throws NoHotelBookingFoundException {
		String userId = (String) session.getAttribute("userId");
		if (userId == null)
			return new ResponseEntity<List<BookedHotel>>(HttpStatus.UNAUTHORIZED);
		List<BookedHotel> hotel = us.allBookedHotels(userId);
		if (hotel.size() > 0) {
			return new ResponseEntity<List<BookedHotel>>(hotel, HttpStatus.FOUND);
		}
		logger.error("No Hotel Booked by user " + userId);
		throw new NoHotelBookingFoundException("No booking Done by user");
	}

	@GetMapping("checkHotel/{hotelId}")
	public ResponseEntity<Hotel> checkHotel(@PathVariable("hotelId") String hotelId, Model m) {
		Hotel hotel = hs.viewHotel(hotelId);
		return new ResponseEntity<Hotel>(hotel, HttpStatus.FOUND);
	}

}
