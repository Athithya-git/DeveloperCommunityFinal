package com.cg.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Users;
import com.cg.service.UserService;

@RestController
public class RegisterController {

	@Autowired
	UserService userService;

//registering the user data in the database
	@PostMapping(path = "/register", consumes = { "application/json" })
	public ResponseEntity<String> userRegistration(@Valid @RequestBody Users users) {
		String message = null;
		boolean flag = userService.register(users);
		if (flag) {
			message = "Registered Successfully";
		}
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}

}
