package com.souvy.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.stereotype.Component;

@Component
@Entity
public class UserLoginDetails {
	@Id
	String username;
	String password;
	String email;
	String sQues;
	String sAns;
	public UserLoginDetails(String username, String password, String email, String sQues, String sAns) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.sQues = sQues;
		this.sAns = sAns;
	}
	public String getsQues() {
		return sQues;
	}
	public void setsQues(String sQues) {
		this.sQues = sQues;
	}
	public String getsAns() {
		return sAns;
	}
	public void setsAns(String sAns) {
		this.sAns = sAns;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UserLoginDetails() {
		super();
	}
	@Override
	public String toString() {
		return "UserLogin [username=" + username + ", password=" + password + ", email=" + email + ", sQues=" + sQues
				+ ", sAns=" + sAns + "]";
	}
	
	
	
}
