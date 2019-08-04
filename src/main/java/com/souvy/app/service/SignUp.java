package com.souvy.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.souvy.app.model.User;
import com.souvy.app.model.UserDetails;
import com.souvy.app.model.UserLoginDetails;
import com.souvy.app.model.UserLoginRepo;
import com.souvy.app.model.UserRepo;

@Component
public class SignUp {
	@Autowired
	UserRepo userRepo;
	@Autowired
	UserLoginRepo userLoginRepo;
	@Autowired
	User user;
	@Autowired
	UserLoginDetails userLogin;
	public String newUser(UserDetails userDetails) {
		
		user.setId(userDetails.getId());
		user.setEmail(userDetails.getEmail());
		user.setName(userDetails.getName());
		user.setDepartment(userDetails.getDepartment());
		user.setPhoneNumber(userDetails.getPhoneNumber());
		System.out.println(user);
		userLogin.setsQues(userDetails.getsQues());
		userLogin.setsAns(userDetails.getsAns());
		userLogin.setUsername(userDetails.getId());
		userLogin.setPassword(userDetails.getPassword());
		userLogin.setEmail(userDetails.getEmail());
		
		User response = userRepo.save(user);
		UserLoginDetails respons1 = userLoginRepo.save(userLogin);
		if (response==null || respons1==null){
			return ("Fail");
		}
		return ("Success");
	}
}
