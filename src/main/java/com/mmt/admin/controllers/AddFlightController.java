package com.mmt.admin.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mmt.admin.service.AdminServiceInterface;
import com.mmt.flights.model.Flight;

@RestController
public class AddFlightController {
    @Autowired
    private AdminServiceInterface as;
    
    Logger logger = LoggerFactory.getLogger(AddFlightController.class);

    @PostMapping("addFlight") // -- addFFlightPage
    public ResponseEntity<Flight> addFlight(@Valid @RequestBody Flight flight ,BindingResult br ,Model m) {
    	if(br.hasErrors()) {
    		  return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
    	}else {
    		Flight flightCreated = as.addFlight(flight);
            return new ResponseEntity<Flight>(flightCreated , HttpStatus.CREATED);
    	}
        
    }
}
