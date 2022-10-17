package com.mmt.admin.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.mmt.admin.service.AdminServiceInterface;
import com.mmt.hotels.model.Hotel;

@RestController
public class AddHotelController {
	@Autowired
	private AdminServiceInterface as;
	Logger logger = LoggerFactory.getLogger(AddHotelController.class);
	
	@PostMapping("addHotel") // -- addHotelPage
	public ResponseEntity<Hotel> addHotel(@Valid @RequestBody Hotel hotel,BindingResult br) {
		if(br.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}
		else {
			Hotel hotelCreated =as.addHotel(hotel);
			return new ResponseEntity<Hotel>(hotelCreated , HttpStatus.CREATED);
		}
		
	}
	
	
}
