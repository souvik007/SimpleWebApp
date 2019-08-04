package com.souvy.app.model;

import org.springframework.stereotype.Component;

@Component
public class ForgetPasswordPojo {

	private String username;
	private String sQues;
	private String sAns;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	@Override
	public String toString() {
		return "ForgetPasswordPojo [username=" + username + ", sQues=" + sQues + ", sAns=" + sAns + "]";
	}
	public ForgetPasswordPojo(String username, String sQues, String sAns) {
		super();
		this.username = username;
		this.sQues = sQues;
		this.sAns = sAns;
	}
	public ForgetPasswordPojo() {
		super();
	}
	
}
