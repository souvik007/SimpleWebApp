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
	String department;
	String phoneNumber;

	public UserDetails(String id, String name, String email, String password, String sQues, String sAns,
			String department, String phoneNumber) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.sQues = sQues;
		this.sAns = sAns;
		this.department = department;
		this.phoneNumber = phoneNumber;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getId() {
		return id;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
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
	public UserDetails() {
		super();
	}
	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", sQues="
				+ sQues + ", sAns=" + sAns + ", department=" + department + ", phoneNumber=" + phoneNumber + "]";
	}
	
	
	
	
}
