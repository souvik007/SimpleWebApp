package com.souvy.app.model;

import org.springframework.stereotype.Component;
@Component

public class UserDetails {
	String id;
	String name;
	String email;
	String password;
	String sQues;
	String sAns;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public UserDetails(String id, String name, String email, String password, String sQues, String sAns) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.sQues = sQues;
		this.sAns = sAns;
	}
	public UserDetails() {
		super();
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", sQues=" + sQues
				+ ", sAns=" + sAns + "]";
	}
	
	
	
	
}
