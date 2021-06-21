package com.cg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.entity.Users;

@Service
public interface UserService {

	public List<Users> getAllUsers();

	public Users getById(String userId);

	public Users saveUsers(Users user);

	public boolean register(Users users);

	public Users validateLogin(String userId, String password, Users users);

	public Users validateLogout(String userId, String password, Users users);

}
