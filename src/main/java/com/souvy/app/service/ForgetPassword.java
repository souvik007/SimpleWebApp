package com.souvy.app.service;

import java.util.HashMap;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.souvy.app.model.ForgetPasswordNewPojo;
import com.souvy.app.model.ForgetPasswordPojo;
import com.souvy.app.model.ForgetPasswordResponse;
import com.souvy.app.model.UserLoginDetails;
import com.souvy.app.model.UserLoginRepo;

@Component
public class ForgetPassword {
	@Autowired
	UserLoginDetails userLoginDetails;
	
	@Autowired
	UserLoginRepo userLoginRepo;
	
	@Autowired
	ForgetPasswordResponse forgetPasswordResponse;
	
	public static HashMap<Double,String> usernameFP=new HashMap<Double,String>() ;
	
	public ResponseEntity<ForgetPasswordResponse> fpLogic(ForgetPasswordPojo details) {
		userLoginDetails.setUsername("no user exist");
		userLoginDetails = userLoginRepo.findById(details.getUsername()).orElse(userLoginDetails);
		
		if(userLoginDetails.getsQues().equals("no user exist")) {
			forgetPasswordResponse.setMessage("no user exist");
		}
		else {
			if(details.getsQues().equals(userLoginDetails.getsQues()) && details.getsAns().equals(userLoginDetails.getsAns())){
				double token = new Random().nextGaussian();
				
				usernameFP.put(token,userLoginDetails.getUsername());
				forgetPasswordResponse.setMessage("next");
				forgetPasswordResponse.setToken(token);
			}
			else {
				forgetPasswordResponse.setMessage("wrong answer");
			}
		}
		return new ResponseEntity<ForgetPasswordResponse>(forgetPasswordResponse,HttpStatus.OK);
	}
	@Transactional
	public String updatePassword(ForgetPasswordNewPojo forgetPasswordNewPojo) {
	
		int i=0 ;
		if(usernameFP.containsKey(Double.parseDouble(forgetPasswordNewPojo.getToken()))) {
			System.out.println(usernameFP.get(Double.parseDouble(forgetPasswordNewPojo.getToken())));
			i = userLoginRepo.setPassword(forgetPasswordNewPojo.getPassword(), usernameFP.get(Double.parseDouble(forgetPasswordNewPojo.getToken())));
			
		}
		if (i==1) {
			usernameFP.remove((Double.parseDouble(forgetPasswordNewPojo.getToken())));		
			return ("success");
			
		}
		else {
			return ("fail");
		}
	}
	
	
	
}
