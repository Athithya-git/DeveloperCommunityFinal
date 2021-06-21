package com.cg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.entity.Developer;

@Service
public interface DeveloperService {

	public List<Developer> getAllDevelopers();

	public Developer getById(int devId);

	public Developer editDeveloper(Developer developer);

	Developer saveDeveloper(Developer developer);

	public Developer addDeveloper(Developer developer);

}
