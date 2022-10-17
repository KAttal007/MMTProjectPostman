package com.mmt.admin.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mmt.admin.model.Admin;
import com.mmt.admin.service.AdminServiceInterface;

@RestController
public class AdminSignUpController {
	@Autowired
	private AdminServiceInterface as;
	
	Logger logger = LoggerFactory.getLogger(AdminSignUpController.class);
	
	@PostMapping("createAdmin")
	public ResponseEntity<Admin> adminSignUp(@RequestBody Admin admin, BindingResult br)
	{
		Admin adminSignUp = as.createAdmin(admin);
		return new ResponseEntity<Admin>(adminSignUp, HttpStatus.CREATED);	
	}
}