package com.mmt.hotels.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.mmt.bookedHotel.model.BookedHotel;
import com.mmt.hotels.services.HotelServiceInterface;
import com.mmt.payment.CardDetails;

@RestController
public class BookHotelsController {
	@Autowired
	private HotelServiceInterface hs;
	Logger logger = LoggerFactory.getLogger(BookHotelsController.class);

	@GetMapping("bookHotel") // --------bookHotelForm
	public ResponseEntity<BookedHotel> bookHotel(@Valid @RequestBody CardDetails cardHotel, BindingResult br,
			HttpSession session) {
		String userId = (String) session.getAttribute("userId");
		if (br.hasErrors()) {
			logger.error("Incorrect Payment Details entered by User " + userId);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		if (userId == null) {
			logger.error("No User ");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		String hotelId = (String) session.getAttribute("hotelId");
		boolean isAc = (boolean) session.getAttribute("isAc");
		int noOfRooms = (int) session.getAttribute("noOfRooms");
		session.removeAttribute("hotelId");
		session.removeAttribute("isAc");
		session.removeAttribute("noOfRooms");
		BookedHotel hotel = hs.bookHotel(hotelId, userId, noOfRooms, isAc);
		logger.info("User " + userId + " has booked Hotel " + hotelId + " with number of rooms " + noOfRooms);
		return new ResponseEntity<BookedHotel>(hotel, HttpStatus.ACCEPTED);
	}
}
