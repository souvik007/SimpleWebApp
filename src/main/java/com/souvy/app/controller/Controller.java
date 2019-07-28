package com.souvy.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.souvy.app.model.LogIn;
import com.souvy.app.model.SignUp;
import com.souvy.app.model.UserDetails;
import com.souvy.app.model.UserLogin;


@org.springframework.stereotype.Controller
public class Controller {
	@Autowired
	SignUp signUp;
	@Autowired
	LogIn login;
	@RequestMapping("/")
	public String load() {
		return "home";
	}
	
	@PostMapping("signup")
	@ResponseBody
	public String signUp(@RequestBody UserDetails user) throws JsonProcessingException {
		String response;
		System.out.println("in signup");
		System.out.println(user);
		response = new ObjectMapper().writeValueAsString(signUp.newUser(user));
		return response;	
	}
	
	@PostMapping("login")
	@ResponseBody
	public String home(@Valid @RequestBody UserLogin userLog, Errors error) throws JsonProcessingException {
		String response = login.signIn(userLog);
		System.out.println(response);
		return response;
	}

	

}
