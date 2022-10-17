package com.mmt.user.controllers;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mmt.user.exceptions.UserNotFoundException;
import com.mmt.user.model.User;
import com.mmt.user.services.UserServiceInterface;

@RestController
public class UserLoginController {
	@Autowired
	private UserServiceInterface us;

	Logger logger = LoggerFactory.getLogger(UserLoginController.class);

	@ExceptionHandler(value = { UserNotFoundException.class })
	public ResponseEntity<User> UserNotFoundExceptionHandler(Model m) {
		m.addAttribute("message", "User not found in database");
		logger.error("User Not Found");
		// return "redirect:/userLoginNav";
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("userLogin")
	public ResponseEntity<User> userLogin(@RequestBody User user, HttpSession session, Model m)
			throws UserNotFoundException {
		User userLogin = us.userLogin(user);
		if (userLogin != null) {
			String userId = us.userName(user.getMailID(), user.getPassword());
			session.setAttribute("userId", userId);
			return new ResponseEntity<User>(userLogin, HttpStatus.OK);
		}
		throw new UserNotFoundException("User Not Found");
	}

	@GetMapping("userLogout")
	public ResponseEntity<Void> userLogout(User user,HttpSession session) {
		//String userId = us.userName(user.getMailID(), user.getPassword());
		session.removeAttribute("userId");
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
