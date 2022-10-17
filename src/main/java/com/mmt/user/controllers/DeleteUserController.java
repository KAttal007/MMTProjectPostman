package com.mmt.user.controllers;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RestController;

import com.mmt.user.exceptions.UserNotDeletedException;
import com.mmt.user.services.UserServiceInterface;

@RestController
public class DeleteUserController {
	@Autowired
	private UserServiceInterface us;

	Logger logger = LoggerFactory.getLogger(DeleteUserController.class);

	@ExceptionHandler(value = UserNotDeletedException.class)
	public ResponseEntity<String> userNotDeletedExceptionHandler() {
		logger.error("User Not Found");
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("deleteUserByUser")
	public ResponseEntity<String> deleteUserByUser(HttpSession session, Model m) throws UserNotDeletedException {
		String userId = (String) session.getAttribute("userId");
		if (userId == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		if (us.deleteUser(userId)) {
			session.removeAttribute("userId");
			return new ResponseEntity<String>("Deleted", HttpStatus.ACCEPTED);
		}
		throw new UserNotDeletedException("User Not Deleted");
	}
}
