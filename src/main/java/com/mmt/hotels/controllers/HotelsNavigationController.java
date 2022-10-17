package com.mmt.hotels.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mmt.hotels.model.Hotel;

@RestController
public class HotelsNavigationController {

	Logger logger = LoggerFactory.getLogger(HotelsNavigationController.class);

	@RequestMapping("searchHotels")
	public String searchHotels() {
		return "searchHotelPage";
	}

	@RequestMapping("goUpdateHotel")
	public String goUpdateHotel(Model m) {
		m.addAttribute("updateHotel", new Hotel());
		return "updateHotelPage";
	}
}
