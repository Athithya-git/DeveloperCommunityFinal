package com.cg.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Developer;
import com.cg.repository.DeveloperRepository;
import com.cg.service.DeveloperService;

@Service
public class DeveloperServiceImpl implements DeveloperService {
	@Autowired
	DeveloperRepository developerRepository;

	@Override
	// getting the developer data
	public List<Developer> getAllDevelopers() {

		return developerRepository.findAll();
	}

	// getting the developer data of particular developer id
	@Override
	public Developer getById(int devId) {

		Developer developer = developerRepository.getById(devId);

		return developer;
	}

// editing and updating the developer data
	@Override
	public Developer editDeveloper(Developer developer) {
		Developer newDeveloper = developerRepository.save(developer);
		return newDeveloper;
	}

	// adding and saving the developer data
	@Override
	public Developer addDeveloper(Developer Developer) {
		// TODO Auto-generated method stub
		Developer newDeveloper = developerRepository.save(Developer);

		return newDeveloper;
	}

	@Override
	public Developer saveDeveloper(Developer developer) {
		Developer newDeveloper = developerRepository.save(developer);
		return newDeveloper;
	}
}