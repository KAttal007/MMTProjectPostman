package com.mmt.user.controllers;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RestController;

import com.mmt.user.exceptions.UserNotUpdatedException;
import com.mmt.user.model.User;
import com.mmt.user.services.UserServiceInterface;

@RestController
public class UpdateDetailsController {
	@Autowired
	private UserServiceInterface us;

	Logger logger = LoggerFactory.getLogger(UpdateDetailsController.class);

	@ExceptionHandler(value = { UserNotUpdatedException.class })
	public ResponseEntity<Void> userNotUpdatedDetailsExceptionHandler(Model m) {
		logger.error("User Details Not Updated");
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}

	@PutMapping("updateUserDetails")
	public ResponseEntity<User> updateUserDetails(User user, HttpSession session, BindingResult br)
			throws UserNotUpdatedException {
		String userId = (String) session.getAttribute("userId");
		if (br.hasErrors()) {
			throw new UserNotUpdatedException("Details Not Updated");
		}
		if (userId == null)
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		User updateUser = us.updateUser(user, userId);
		return new ResponseEntity<User>(updateUser, HttpStatus.ACCEPTED);
	}

}
