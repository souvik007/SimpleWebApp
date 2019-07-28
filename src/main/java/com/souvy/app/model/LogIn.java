package com.souvy.app.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class LogIn {
	@Autowired
	UserLoginRepo userLoginRepo;
	
	@Autowired
	UserRepo userRepo;
	public String signIn(UserLogin user) throws JsonProcessingException,NullPointerException{
		String response="";
		UserLogin userLogin=null;
		User userInfo=null;
		if (userLoginRepo.existsById(user.username)) {
			userLogin=userLoginRepo.findById(user.username).orElse(null);
			userInfo=userRepo.findById(user.username).orElse(null);
		}
		if(userLogin==null) {
			response = new ObjectMapper().writeValueAsString("not valid user");
			return response;
		}
		else if(userLogin.password.equals(user.getPassword())) {
			response = new ObjectMapper().writeValueAsString(userInfo);
			return response;
		}
		else {
			response = new ObjectMapper().writeValueAsString("wrong password");
			return response;
		}
		
	}
}
