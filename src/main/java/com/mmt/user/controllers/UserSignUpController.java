package com.mmt.user.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.mmt.user.exceptions.EmailAlreadyExistsException;
import com.mmt.user.model.User;
import com.mmt.user.services.UserServiceInterface;

@RestController
public class UserSignUpController {
	@Autowired
	private UserServiceInterface us;

	Logger logger = LoggerFactory.getLogger(UserSignUpController.class);

	@ExceptionHandler(value = { EmailAlreadyExistsException.class })
	public ResponseEntity<User> EmailAlreadyExistExceptionHandler(Model m) {
		logger.error("Email ID alredy in use");
		// return "redirect:/userLoginNav";
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}

	@PostMapping("createUser")
	public ResponseEntity<User> userSignUp(@Valid @RequestBody User user, BindingResult br, HttpSession session)
			throws EmailAlreadyExistsException {
		String userId = (String) session.getAttribute("userId");
		if (userId != null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		if (br.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		User newUser = us.createuser(user);
		if (newUser != null) {
			return new ResponseEntity<>(newUser, HttpStatus.CREATED);
		}
		throw new EmailAlreadyExistsException("Email Alredy exist");
	}
}
