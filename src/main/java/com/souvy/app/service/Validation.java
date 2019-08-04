package com.souvy.app.service;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.souvy.app.model.User;
import com.souvy.app.model.UserDetails;
import com.souvy.app.model.ValidationResponse;



@Component
public class Validation {
	
	@Autowired
	ValidationResponse validationResponse;
	
	public ValidationResponse signUpValidation(UserDetails userDetails) {
		System.out.println(userDetails);
		String patternEmail ="^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}([\\.])+[a-z]{2,}$";
		String patternPassword = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$";
		String patternPhoneNumber ="([0-9]){10}";
		
		
		
		Map<String, String> error=new HashMap<String, String>();
		validationResponse.setStatus("pass");
		
		if(userDetails.getId()=="") {
			validationResponse.setStatus("fail");
			error.put("errorId", "Id cant be empty");
		}
		if(userDetails.getName()=="") {
			validationResponse.setStatus("fail");
			error.put("errorName", "Name cant be empty");
		}
		if(userDetails.getsAns()=="") {
			validationResponse.setStatus("fail");
			error.put("errorSAns", "Security answer cant be empty");
		}
		if(!Pattern.matches(patternEmail, userDetails.getEmail())) {
			validationResponse.setStatus("fail");
			error.put("errorEmail", "format of email is wrong");
		}
		if(!Pattern.matches(patternPassword, userDetails.getPassword())) {
			validationResponse.setStatus("fail");
			error.put("errorPassword", "password must include uppercase,lowercase,number,special symbol and 6 to 12 character");
		}
		if(!Pattern.matches(patternPhoneNumber, userDetails.getPhoneNumber())) {
			validationResponse.setStatus("fail");
			error.put("errorPhoneNumber", "size must be 10");
		}
		
		validationResponse.setErrors(error);
		return validationResponse;
		
	}
	
	
	public ValidationResponse updateValidation(User user) {
		System.out.println(user);
		String patternEmail ="^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}([\\.])+[a-z]{2,}$";
		//String patternPassword = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$";
		String patternPhoneNumber ="([0-9]){10}";
		
		
		
		Map<String, String> error=new HashMap<String, String>();
		validationResponse.setStatus("pass");
		
		if(user.getId()=="") {
			validationResponse.setStatus("fail");
			error.put("errorIdUD", "Id cant be empty");
		}
		
		if(user.getName()=="") {
			validationResponse.setStatus("fail");
			error.put("errorNameUD", "Name cant be empty");
		}
		
		if(!Pattern.matches(patternEmail, user.getEmail())) {
			validationResponse.setStatus("fail");
			error.put("errorEmailUD", "format of email is wrong");
		}
		if(!Pattern.matches(patternPhoneNumber, user.getPhoneNumber())) {
			validationResponse.setStatus("fail");
			error.put("errorPhoneNumberUD", "size must be 10");
		}
		
		validationResponse.setErrors(error);
		return validationResponse;
		
	}
	
	public String passwordValidation(String password) {
		String patternPassword = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$";
		if(!Pattern.matches(patternPassword, password)) {
			return "wrong format";
		}
		else
			return "right format";
		
	}
}


