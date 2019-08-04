package com.souvy.app.model;

import org.springframework.stereotype.Component;

@Component
public class UserLogin {
	String username;
	String password;
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
	@Override
	public String toString() {
		return "UserLogin [username=" + username + ", password=" + password + "]";
	}
	public UserLogin(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public UserLogin() {
		super();
	}
	
	
}
