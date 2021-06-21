package com.cg.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Users {

	@Id
	@NotEmpty(message = "User Id can't be empty !")
	@Size(min = 5, max = 20, message = "User Id has to be minimum 5 chars!")
	String userId;

	@NotEmpty(message = "password can't be empty !")
	@Size(min = 8, max = 20, message = "password has to be minimum 8 chars!")
	String password;

	@NotEmpty(message = "Role type can't be empty !")
	@Size(min = 2, max = 25, message = "Invalid role please enter valid role! ")
	String role;

	public Users(String userId, String password, String role) {
		super();
		this.userId = userId;
		this.password = password;
		this.role = role;

	}

	public Users() {

	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", password=" + password + ", role=" + role + "]";
	}

}
