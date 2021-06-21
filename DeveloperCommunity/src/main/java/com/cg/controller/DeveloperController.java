package com.cg.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Developer;
import com.cg.entity.Users;
import com.cg.exception.DeveloperIdNotFoundException;
import com.cg.service.DeveloperService;
import com.cg.service.UserService;

@RestController
@RequestMapping("/api/v1")
public class DeveloperController {

	@Autowired
	DeveloperService developerService;
	@Autowired
	UserService userService;
	List<Developer> developers = new ArrayList<Developer>();

	public DeveloperController() {
		developers.add(new Developer(0, null, null, null, null, 0, 0, false, false));

	}

	public List<Developer> getAllDevelopers() {
		return developers;
	}

	// adding and saving the developer data in the database
	@PostMapping(path = "/developers", consumes = { "application/json" })
	public ResponseEntity<List<Developer>> saveDevelopers(@RequestBody Developer developer) {

		Developer newDeveloper = developerService.saveDeveloper(developer);

		return new ResponseEntity<List<Developer>>(developers, HttpStatus.OK);
	}

//get developer data by developer

	@GetMapping(path = "/developers/{devId}", produces = { "application/json" })
	public ResponseEntity<Developer> getDeveloperById(@PathVariable("devId") int devId) {
		try {
			if (developerService.getById(devId) == null) {
				System.out.println("id not");
				throw new DeveloperIdNotFoundException();
			} else {
				Developer developer = developerService.getById(devId);
				return new ResponseEntity<Developer>(developer, HttpStatus.OK);
			}
		} catch (DeveloperIdNotFoundException developerNotFoundException) {
			System.out.println("id not");
			return new ResponseEntity(developerNotFoundException.getMessage(), HttpStatus.CONFLICT);

		}
	}

// finding the developer id in the database
	private Developer findById(int developerId) {
		List<Developer> developers = getAllDevelopers();

		for (Developer de : developers) {
			if (de.getDevId() == developerId) {
				return de;
			}
		}
		return null;
	}

// getting all the developer data in the database
	@GetMapping(path = "/developers", produces = { "application/json" })
	public ResponseEntity<List<Developer>> getDevelopers() {
		List<Developer> developersList = developerService.getAllDevelopers();

		return new ResponseEntity<List<Developer>>(developersList, HttpStatus.OK);
	}

//editing and updating the developer data in the database
	@PutMapping("/developers/{devId}")
	public ResponseEntity<Developer> updateDeveloper(@PathVariable(value = "devId") int devId,
			@RequestBody Developer developerDetails) {
		if (developerService.getById(devId) != null
				|| developerService.getById(devId) != developerService.getById(devId)) {

			Developer developer = developerService.getById(devId);
			// .orElseThrow(() -> new ResourceNotFoundException("Developer not found for
			// this id :: " + devId));

			developer.setEmail(developerDetails.getEmail());
			developer.setName(developerDetails.getName());
			developer.setSkillLevel(developerDetails.getSkillLevel());
			developer.setMemberSince(developerDetails.getMemberSince());
			developer.setSkillLevel(developerDetails.getSkillLevel());
			developer.setReputation(developerDetails.getReputation());

			final Developer updatedDeveloper = developerService.editDeveloper(developer);
			return ResponseEntity.ok(updatedDeveloper);
		} else {
			throw new DeveloperIdNotFoundException();
		}
	}

	// adding and saving the developer data in the database with user id
	@PostMapping(path = "/add/developer/{userId}", consumes = { "application/json" })
	public ResponseEntity<List<Developer>> addDeveloper(@RequestBody Developer developer, @PathVariable String userId) {

		Users users = userService.getById(userId);
		developer.setUsers(users);

		if (developerService.addDeveloper(developer) == null) {
			throw new ResourceNotFoundException("Developer Not found");
		} else {
			developerService.addDeveloper(developer);
		}

		List<Developer> developerList = developerService.getAllDevelopers();
		return new ResponseEntity<List<Developer>>(developerList, HttpStatus.OK);

	}
}
