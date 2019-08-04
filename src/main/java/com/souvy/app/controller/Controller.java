package com.souvy.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.souvy.app.model.ChangePasswordPojo;
import com.souvy.app.model.ForgetPasswordNewPojo;
import com.souvy.app.model.ForgetPasswordPojo;
import com.souvy.app.model.ForgetPasswordResponse;
import com.souvy.app.model.SearchPojo;
import com.souvy.app.model.User;
import com.souvy.app.model.UserDetails;
import com.souvy.app.model.UserLogin;
import com.souvy.app.model.ValidationResponse;
import com.souvy.app.service.ChangePassword;
import com.souvy.app.service.ForgetPassword;
import com.souvy.app.service.LogIn;
import com.souvy.app.service.Logout;
import com.souvy.app.service.SearchLogic;
import com.souvy.app.service.SignUp;
import com.souvy.app.service.UserDetailsEdit;
import com.souvy.app.service.Validation;


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
	@Autowired
	ForgetPassword forgetPassword;
	@Autowired
	ChangePassword changePassword;
	@Autowired
	UserDetailsEdit userDetailsEdit;
	@Autowired
	Validation validation;
	
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
	
	@PostMapping("forgetpassword")
	@ResponseBody
	public ResponseEntity<ForgetPasswordResponse> forgetPass(@RequestBody ForgetPasswordPojo details,HttpSession httpSession) throws JsonProcessingException {
		
		System.out.println(httpSession.hashCode());
		System.out.println("in forget password");
		System.out.println(details);
		//response = new ObjectMapper().writeValueAsString(signUp.newUser(user));
		
		return forgetPassword.fpLogic(details);	
	}
	
	@PostMapping("updatepass")
	@ResponseBody
	public String updatePass(@RequestBody ForgetPasswordNewPojo forgetPasswordNewPojo,HttpSession httpSession) throws JsonProcessingException {
		String response;
		System.out.println(httpSession.hashCode());
		System.out.println("in update password");
		System.out.println(forgetPasswordNewPojo);
		String validate= validation.passwordValidation(forgetPasswordNewPojo.getPassword());
		if(validate.equals("right format")) {
			response = new ObjectMapper().writeValueAsString(forgetPassword.updatePassword(forgetPasswordNewPojo));
		}
		else {
			response = new ObjectMapper().writeValueAsString(validate);

		}
		System.out.println(response);
		return response;	
	}
	
	@PostMapping("changepass")
	@ResponseBody
	public String changePass(@RequestBody ChangePasswordPojo changePasswordPojo, HttpSession httpSession) throws JsonProcessingException {
		String response;
		System.out.println(httpSession.hashCode());
		System.out.println("in change password");
		
		String validate= validation.passwordValidation(changePasswordPojo.getNewPass());
		
		if(validate.equals("right format")) {
			response = new ObjectMapper().writeValueAsString(changePassword.changePassLogic(changePasswordPojo,httpSession));
		}
		else {
			response = new ObjectMapper().writeValueAsString(validate);
		} 
		
		System.out.println(response);
		return response;	
	}
	
	@PostMapping("signup")
	@ResponseBody
	public ResponseEntity<ValidationResponse> signUp( @RequestBody UserDetails user,HttpSession httpSession) throws JsonProcessingException {
		
		System.out.println(httpSession.hashCode());
		System.out.println("in signup");
		System.out.println(user);
		ValidationResponse validationResponse = validation.signUpValidation(user);
		
		if(validationResponse.getStatus().equals("pass")) {
			signUp.newUser(user);
		}
		return new ResponseEntity<ValidationResponse> (validationResponse,HttpStatus.OK);
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
	
	@PostMapping("userdetailsedit")
	@ResponseBody
	public ResponseEntity<ValidationResponse> userEdit(@RequestBody User user,HttpSession httpSession) throws JsonProcessingException {
		System.out.println(httpSession.hashCode());
		System.out.println("in user details edit");
		ValidationResponse validationResponse = validation.updateValidation(user);
		if(validationResponse .getStatus().equals("pass")) {
			 userDetailsEdit.updateUserDetails(user,httpSession);
		}
		return new ResponseEntity<ValidationResponse> (validationResponse,HttpStatus.OK);	
	}
	

}
