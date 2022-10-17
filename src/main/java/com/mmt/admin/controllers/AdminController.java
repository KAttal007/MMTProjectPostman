package com.mmt.admin.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mmt.admin.model.Admin;
import com.mmt.flights.model.Flight;
import com.mmt.hotels.model.Hotel;

@RestController
public class AdminController {
	
	Logger logger = LoggerFactory.getLogger(AdminController.class);
	@RequestMapping("adminSignUpNav")
	public String adminSignUpPage(Model m) {
		m.addAttribute("admin" ,new Admin());
		return "adminSignUpPage";
	}
	
	@RequestMapping("adminLoginNav")
	public String adminLogin() {
		return "adminLoginPage";
	}
	
	@RequestMapping("adminHomePage")
	public String adminHomePage() {
		return "adminHomePage";
	}
	
	@RequestMapping("goAddFlights")
	public String goAddFlights(Model m) {
		m.addAttribute("flight" , new Flight());
		return "addFlightPage";
	}
	
	@RequestMapping("goRemoveHotel")
	public String goRemoveHotel() {
		return "removeHotelPage";
	}
	
	@RequestMapping("goRemoveFlight")
	public String goRemoveFlight() {
		return "removeFlightPage";
	}
	@RequestMapping("goAddHotel")
	public String addHotelNav(Model m) {
		m.addAttribute("hotel" , new Hotel());
		return "addHotelPage";
	}
}
