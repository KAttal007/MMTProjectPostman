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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mmt.admin.exceptions.HotelIdNotFoundException;
import com.mmt.admin.exceptions.HotelNotDeletedException;
import com.mmt.admin.service.AdminServiceInterface;
import com.mmt.hotels.model.Hotel;

@RestController
public class EditDeleteHotelController {
	@Autowired
	private AdminServiceInterface as;
	
	Logger logger = LoggerFactory.getLogger(EditDeleteHotelController.class);
	
	@ExceptionHandler(value = HotelIdNotFoundException.class)
	public ResponseEntity<Void> hotelIdNotFoundExceptionHandler() {
		logger.error("Hotel Not Found");
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(value = HotelNotDeletedException.class)
	public ResponseEntity<Hotel> HotelIdNotFoundDeleteExceptionHandler(Model m) {
		logger.error("Hotel Not Found");
		return new ResponseEntity<Hotel>(HttpStatus.NOT_MODIFIED);
	}
	
	@PutMapping("updateHotel") //-- updateHotelPage
	public ResponseEntity<Hotel> updateHotel(@Valid @ModelAttribute("updateHotel") Hotel hotel ,BindingResult br ,Model m) throws HotelIdNotFoundException{
		if(br.hasErrors()) {
			logger.error("Hotel Not updated");
			return new ResponseEntity<Hotel>(HttpStatus.NOT_MODIFIED);
			}else {
				Hotel updateHotel = as.updateHotel(hotel);
				if(updateHotel!=null) {
					return new ResponseEntity<Hotel>( updateHotel, HttpStatus.ACCEPTED);
				}
				throw new HotelIdNotFoundException("Hotel not updated");
			}
	}
	
	@DeleteMapping("deleteHotel/{hotelId}") 
	public ResponseEntity<Void> deleteHotel(@PathVariable("hotelId")String hotelId) throws HotelNotDeletedException{
		
		if(as.removeHotel(hotelId)) {
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		}
		throw new HotelNotDeletedException("Hotel Not Deleted");
	}
}