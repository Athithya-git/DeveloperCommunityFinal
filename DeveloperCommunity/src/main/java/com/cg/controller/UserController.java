package com.cg.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Users;
import com.cg.exception.ResourceNotFoundException;
import com.cg.exception.UserIdNotFoundException;
import com.cg.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserService userService;

	List<Users> users = new ArrayList<Users>();

	public UserController() {
		users.add(new Users(null, null, null));

	}

	public List<Users> getAllUsers() {
		return users;
	}

// login using user credentials
	@PostMapping(path = "/login", consumes = { "application/json" })
	public ResponseEntity<String> loginUser(@Valid @RequestBody Users users) {
		String message = null;

		try {

			Users newUser = userService.validateLogin(users.getUserId(), users.getPassword(), users);

		} catch (Exception e) {
			throw new UserIdNotFoundException("Invalid userId or password .. please enter correct credintials..");
		}

		message = "Welcome back " + users.getRole();
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}

// log out using user credentials
	@PostMapping(path = "/logout", consumes = { "application/json" })
	public ResponseEntity<String> logoutUser(@Valid @RequestBody Users users) {

		String message = null;
		try {
			Users newUser = userService.validateLogout(users.getUserId(), users.getPassword(), users);
		} catch (Exception e) {
			throw new ResourceNotFoundException(" Not registered for this userId please register..");
		}
		message = users.getRole() + " Successfully logged out ";

		return new ResponseEntity<String>(message, HttpStatus.OK);
	}

// adding and saving  the user data in database
	@PostMapping(path = "/users", consumes = { "application/json" })
	public ResponseEntity<List<Users>> saveUsers(@Valid @RequestBody Users user) {

		Users newUsers;
		try {
			newUsers = userService.saveUsers(user);
			if (newUsers == null) {
				throw new ResourceNotFoundException("User Not found..");
			}
		} catch (Exception e) {
			throw new ResourceNotFoundException("Invalid User ");
		}
		return new ResponseEntity<List<Users>>(HttpStatus.OK);
	}

// getting user data from database
	@GetMapping("/admin")
	public ResponseEntity<List<Users>> getUser() {
		List<Users> userList;
		try {
			userList = userService.getAllUsers();
		} catch (Exception e) {
			throw new ResourceNotFoundException("User Not found..");
		}

		return new ResponseEntity<List<Users>>(userList, HttpStatus.OK);

	}

}
