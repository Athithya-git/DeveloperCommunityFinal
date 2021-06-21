package com.cg.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Users;
import com.cg.exception.ResourceNotFoundException;
import com.cg.repository.UserRepository;
import com.cg.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repo;

// getting the user data
	@Override
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	// getting the user data by user id
	@Override
	public Users getById(String id) {
		// TODO Auto-generated method stub
		Users users = repo.getById(id);

		if (users == null) {
			throw new ResourceNotFoundException("Product not found for userId " + id);
			// throw new NullPointerException();
		}
		return users;

	}

	// adding and saving the user data
	@Override
	public Users saveUsers(Users user) {
		// TODO Auto-generated method stub
		Users users = repo.save(user);

		return users;
	}

	// registering the user credentials
	@Override
	public boolean register(Users users) {

		Users userIdDb = repo.getById(users.getUserId());

		if (userIdDb == null) {
			repo.save(users);
			return true;
		}
		throw new ResourceNotFoundException(users.getUserId() + "already register");
	}

// validating the  login user data
	@Override
	public Users validateLogin(String userId, String password, Users users) {

		Users userIdDb = repo.getById(users.getUserId());

		if (userIdDb == null) {
			throw new ResourceNotFoundException(
					"UserId or password is incorrect .. please enter correct credintials..");
		}
		return userIdDb;
	}

// validating the logout user data
	@Override
	public Users validateLogout(String userId, String password, Users users) {
		// TODO Auto-generated method stub
		Users userIdDb = repo.getById(users.getUserId());
		// Users userIdDb1=repo.getByPassword(users.getPassword());

		if (userIdDb == null) {
			throw new ResourceNotFoundException("Don't have account please Register..");
		}
		return userIdDb;
	}

}

/*
 * Optional<Users> users =repo.findById(id);
 * 
 * if(users.isEmpty() || users==null) { throw new
 * ResourceNotFoundException("Product not found for price range " +id); //throw
 * new NullPointerException(); }
 * 
 * 
 * return users.get();
 * 
 * 
 * 
 * @Override public Users getById(int id) { // TODO Auto-generated method stub
 * Users users=repo.getById(id); return users; }
 * 
 */