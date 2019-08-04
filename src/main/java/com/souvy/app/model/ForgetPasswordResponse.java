package com.souvy.app.model;

import org.springframework.stereotype.Component;

@Component
public class ForgetPasswordResponse {
	
	String message;
	double token;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public double getToken() {
		return token;
	}
	public void setToken(double token) {
		this.token = token;
	}
	public ForgetPasswordResponse() {
		super();
	}
	public ForgetPasswordResponse(String message, double token) {
		super();
		this.message = message;
		this.token = token;
	}
	@Override
	public String toString() {
		return "ForgetPasswordResponse [message=" + message + ", token=" + token + "]";
	}
}
