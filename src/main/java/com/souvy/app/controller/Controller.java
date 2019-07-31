package com.souvy.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.souvy.app.model.SearchPojo;
import com.souvy.app.model.User;
import com.souvy.app.model.UserDetails;
import com.souvy.app.model.UserLogin;
import com.souvy.app.model.service.LogIn;
import com.souvy.app.model.service.Logout;
import com.souvy.app.model.service.SearchLogic;
import com.souvy.app.model.service.SignUp;


@org.springframework.stereotype.Controller
public class Controller {
	@Autowired
	SignUp signUp;
	@Autowired
	LogIn login;
	@Autowired
	SearchLogic searchLogic;
	@Autowired
	Logout logout;
	
	@RequestMapping("/")
	public String load(HttpSession httpSession) {
		System.out.println(httpSession.hashCode());
		return "home";
	}
	
	@PostMapping("checkloginexist")
	@ResponseBody
	public ResponseEntity<User> checkLoginExist(HttpSession httpSession) throws JsonProcessingException {
		
		System.out.println(httpSession.hashCode());
		System.out.println("in signup");
		return (login.loadExistUser(httpSession));
		
	}
	
	@PostMapping("signup")
	@ResponseBody
	public String signUp(@RequestBody UserDetails user,HttpSession httpSession) throws JsonProcessingException {
		String response;
		System.out.println(httpSession.hashCode());
		System.out.println("in signup");
		System.out.println(user);
		response = new ObjectMapper().writeValueAsString(signUp.newUser(user));
		return response;	
	}
	
	@PostMapping("search")
	@ResponseBody
	public ResponseEntity<List<User>> search(@RequestBody SearchPojo search,HttpSession httpSession) throws JsonProcessingException {
		System.out.println(httpSession.hashCode());
		System.out.println("in search");
		System.out.println(search);
		return (searchLogic.searchLogic(search));	
	}
	
	@PostMapping("logout")
	@ResponseBody
	public String logout(HttpSession httpSession) throws JsonProcessingException {
		System.out.println(httpSession.hashCode());
		System.out.println("in logout");
		return (logout.logoutLogic(httpSession));	
	}
	
	@PostMapping("login")
	@ResponseBody
	public ResponseEntity<User> home(@Valid @RequestBody UserLogin userLog, HttpSession httpSession) throws JsonProcessingException {
		
		System.out.println(httpSession.hashCode());
		//String response = login.signIn(userLog);
		//System.out.println(response);
		return login.signIn(userLog,httpSession);
	}

	

}
