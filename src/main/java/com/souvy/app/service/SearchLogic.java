package com.souvy.app.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.souvy.app.model.SearchPojo;
import com.souvy.app.model.User;
import com.souvy.app.model.UserRepo;

@Component
public class SearchLogic {
	@Autowired
	UserRepo userRepo;
	@Autowired
	User userInfo;

	public ResponseEntity<List<User>> searchLogic(SearchPojo searchPojo) {
		
		userInfo.setId("User not found");
		List<User> searchResult;
		if(searchPojo.getSearchCriteria().toLowerCase().equals("email")) {
			searchResult=userRepo.findByEmail(searchPojo.getSearchQuery());
		}
		else {
			searchResult=userRepo.findByDepartment(searchPojo.getSearchQuery());
		}
		if(searchResult == null) {
			searchResult = new ArrayList<User> ();
			searchResult.add(userInfo);
		}
		System.out.println(searchResult);
		ResponseEntity<List<User>> responseEntity= new ResponseEntity<List<User>>(searchResult, HttpStatus.OK);
		System.out.println(responseEntity);
		return responseEntity;

	}
}
