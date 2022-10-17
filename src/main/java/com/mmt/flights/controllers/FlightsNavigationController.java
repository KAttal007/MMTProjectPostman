package com.mmt.flights.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mmt.flights.model.Flight;

@RestController
public class FlightsNavigationController {
	
	
	Logger logger = LoggerFactory.getLogger(FlightsNavigationController.class);
	
	@RequestMapping("searchFlight")
	public String searchFlight() {
		return "searchFlightPage";
	}
	
	@RequestMapping("goUpdateFlight")
	public String goUpdateFlight(Model m) {
		m.addAttribute("updateFlight" , new Flight());
		return "updateFlightPage";
	}
	
}
