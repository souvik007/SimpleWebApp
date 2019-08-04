package com.souvy.app.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.souvy.app.model.SessionDetails;
import com.souvy.app.model.User;
import com.souvy.app.model.UserRepo;

@Component
public class UserDetailsEdit {
	
	@Autowired
	UserRepo userRepo;

	public String updateUserDetails(User user, HttpSession httpSession) {
		
		if(SessionDetails.sessionList.containsKey(httpSession.hashCode())) {
			userRepo.save(user);
			return "success";
		}
		
		else {
			return "unauthorized access";
		}

	}
	
}
