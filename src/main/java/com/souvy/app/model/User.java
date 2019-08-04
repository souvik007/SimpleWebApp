package com.souvy.app.model;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;
import javax.persistence.Id;
@Component
@Entity
public class User {
	
	@Id
	String id;
	String name;
	String email;
	String department;
	String phoneNumber;
	
	public User(String id, String name, String email, String department, String phoneNumber) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
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
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
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


	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", department=" + department
				+ ", phoneNumber=" + phoneNumber + "]";
	}
	
	
	
	
}
