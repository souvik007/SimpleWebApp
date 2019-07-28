package com.souvy.app.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SignUp {
	@Autowired
	UserRepo userRepo;
	@Autowired
	UserLoginRepo userLoginRepo;
	@Autowired
	User user;
	@Autowired
	UserLogin userLogin;
	public String newUser(UserDetails userDetails) {
		user.setId(userDetails.getId());
		user.setEmail(userDetails.getEmail());
		user.setName(userDetails.getName());
		user.setsQues(userDetails.getsQues());
		user.setsAns(userDetails.getsAns());
		userLogin.setUsername(userDetails.getId());
		userLogin.setPassword(userDetails.getPassword());
		userLogin.setEmail(userDetails.getEmail());
		
		User response = userRepo.save(user);
		UserLogin respons1 = userLoginRepo.save(userLogin);
		if (response==null || respons1==null){
			return ("Fail");
		}
		return ("Success");
	}
}
