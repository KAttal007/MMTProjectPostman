package com.mmt.admin.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mmt.admin.exceptions.AdminNotFoundException;
import com.mmt.admin.model.Admin;
import com.mmt.admin.service.AdminServiceInterface;

@RestController
public class AdminLoginController {
	@Autowired
	private AdminServiceInterface as;
	
	Logger logger = LoggerFactory.getLogger(AdminLoginController.class);
	
	@ExceptionHandler(value = AdminNotFoundException.class)
	public ResponseEntity<Admin> adminNotFoundExceptionHandler() {
		logger.error("Wrong Username or Password");
		return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("adminLogin" )//adminLoginPage -- jsp
	public ResponseEntity<Admin> adminLogin(@RequestBody Admin admin) throws AdminNotFoundException{
		
		Admin adminLogin = as.login(admin);
		if(adminLogin!=null) {
			
			return new ResponseEntity<Admin>(adminLogin , HttpStatus.OK);
		}
		throw new AdminNotFoundException("Admin Not Found");
	}
	
	@GetMapping("adminLogout")
	public ResponseEntity<Void> userLogout() {
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
