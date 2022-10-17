package com.mmt.hotels.controllers;

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

import com.mmt.admin.exceptions.HotelIdNotFoundException;
import com.mmt.hotels.model.Hotel;
import com.mmt.hotels.services.HotelServiceInterface;

@RestController
public class ViewHotelsDetailsController {

	@Autowired
	private HotelServiceInterface hs;

	Logger logger = LoggerFactory.getLogger(ViewHotelsDetailsController.class);

	@ExceptionHandler(value = HotelIdNotFoundException.class)
	public ResponseEntity<Void> hotelIdNotFoundExceptionHandler() {
		logger.error("Hotel Not Found");
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("viewHotelDetails/{hotelId}") // -- viewHotelPage
	public ResponseEntity<Hotel> viewHotelDetails(@PathVariable("hotelId") String hotelId, Model m)
			throws HotelIdNotFoundException {
		Hotel hotel = hs.viewHotel(hotelId);
		if (hotel == null)
			throw new HotelIdNotFoundException("Hotel not found");
		return new ResponseEntity<Hotel>(hotel, HttpStatus.FOUND);
	}

	@GetMapping("checkHotelAvailabilty/{hotelId}/isAc/{isAc}/noOfRooms/{noOfRooms}")
	public ResponseEntity<Hotel> checkHotelAvailabilty(@PathVariable("hotelId") String hotelId,
			@PathVariable("isAc") boolean isAc, @PathVariable("noOfRooms") int noOfRooms, HttpSession session) {
		String userId = (String) session.getAttribute("userId");
		if (userId == null)
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		Hotel hotel = hs.isRoomAvilable(hotelId, noOfRooms, isAc);
		if (hotel != null) {
			session.setAttribute("hotelId", hotelId);
			session.setAttribute("noOfRooms", noOfRooms);
			session.setAttribute("isAc", isAc);
			return new ResponseEntity<>(hotel, HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}

//	@RequestMapping("hotelPaymentValidation")
//	public String hotelPaymentValidation(Model m) {
//		m.addAttribute("cardHotel", new CardDetails());
//		return "hotelPaymentPage";
//	}
}
