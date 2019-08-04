package com.souvy.app.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
import com.souvy.app.model.SessionDetails;
import com.souvy.app.model.User;
import com.souvy.app.model.UserLogin;
import com.souvy.app.model.UserLoginDetails;
import com.souvy.app.model.UserLoginRepo;
import com.souvy.app.model.UserRepo;

@Component
public class LogIn {
	@Autowired
	UserLoginRepo userLoginRepo;
	
	@Autowired
	UserRepo userRepo;
	@Autowired
	UserLoginDetails userLogin;
	@Autowired
	User userInfo;
	
	public ResponseEntity<User> signIn(UserLogin user,HttpSession httpSession) throws JsonProcessingException,NullPointerException{
		//String response="";
		userLogin.setUsername("not");
		userInfo.setId("not");
		System.out.println(user.toString());
		if (userLoginRepo.existsById(user.getUsername())) {
			userLogin=userLoginRepo.findById(user.getUsername()).orElse(userLogin);
			userInfo=userRepo.findById(user.getUsername()).orElse(userInfo);
		}
		if(userLogin.getUsername().equals("not")) {
			//response = new ObjectMapper().writeValueAsString("not valid user");
			return (new ResponseEntity<> (userInfo,HttpStatus.BAD_REQUEST));
			
		}
		else if(userLogin.getPassword().equals(user.getPassword())) {
			//response = new ObjectMapper().writeValueAsString(userInfo);
			SessionDetails.sessionList.put(httpSession.hashCode(), user.getUsername());
			return (new ResponseEntity<> (userInfo,HttpStatus.OK));
		}
		else {
			//response = new ObjectMapper().writeValueAsString("wrong password");
			userInfo.setId("Wrong Password");
			return (new ResponseEntity<> (userInfo,HttpStatus.BAD_REQUEST));
		}
		
	}

	public ResponseEntity<User> loadExistUser(HttpSession httpSession) {
		if(SessionDetails.sessionList.containsKey(httpSession.hashCode())) {
			System.out.println(userInfo);
			userInfo=userRepo.findById(SessionDetails.sessionList.get(httpSession.hashCode())).orElse(userInfo);
			return (new ResponseEntity<> (userInfo,HttpStatus.OK));
		}
		else {
			System.out.println("not logged in");
			userInfo.setId("not logged in");
			return (new ResponseEntity<> (userInfo,HttpStatus.BAD_REQUEST));
		}
		
		
	}

	
}
