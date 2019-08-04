package com.souvy.app.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.souvy.app.model.ChangePasswordPojo;
import com.souvy.app.model.SessionDetails;
import com.souvy.app.model.UserLoginDetails;
import com.souvy.app.model.UserLoginRepo;





@Component
public class ChangePassword {

	@Autowired
	UserLoginDetails userLoginDetails;
	
	@Autowired
	UserLoginRepo userLoginRepo;
	
	@Transactional
	public String changePassLogic(ChangePasswordPojo changePasswordPojo, HttpSession httpSession) {
		int i=0;
		if(SessionDetails.sessionList.containsKey(httpSession.hashCode())) {
			userLoginDetails = userLoginRepo.findById(SessionDetails.sessionList.get(httpSession.hashCode())).orElse(null);
			if(userLoginDetails.getPassword().equals(changePasswordPojo.getOldPass())) {
				i = userLoginRepo.setPassword(changePasswordPojo.getNewPass(), SessionDetails.sessionList.get(httpSession.hashCode()));
			}
		}		
		if (i==1) {
			return "success";
		}
		else {
			return "fail";
		}
	}

}
