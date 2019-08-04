package com.souvy.app.model;

import org.springframework.stereotype.Component;

@Component
public class ForgetPasswordNewPojo {
	private String password;
	private String token;
	@Override
	public String toString() {
		return "ForgetPasswordNewPojo [password=" + password + ", token=" + token + "]";
	}
	public ForgetPasswordNewPojo() {
		super();
	}
	public ForgetPasswordNewPojo(String password, String token) {
		super();
		this.password = password;
		this.token = token;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
}
