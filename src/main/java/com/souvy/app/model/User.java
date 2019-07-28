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
	public User(String id, String name, String email, String password, String sQues, String sAns) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.sQues = sQues;
		this.sAns = sAns;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", sQues=" + sQues
				+ ", sAns=" + sAns + "]";
	}
	
	
	
	
}
