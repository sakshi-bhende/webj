package com.cdac.backend.dto;



public class UsersDTO {

	String username;

	String password;

	String email;

	String name;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "UsersDTO [username=" + username + ", password=" + password + ", email=" + email + ", name=" + name
				+ "]";
	}
	
}
