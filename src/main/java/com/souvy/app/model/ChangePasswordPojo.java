package com.souvy.app.model;

import org.springframework.stereotype.Component;

@Component
public class ChangePasswordPojo {

	String oldPass;
	String newPass;
	public ChangePasswordPojo() {
		super();
	}
	public ChangePasswordPojo(String oldPass, String newPass) {
		super();
		this.oldPass = oldPass;
		this.newPass = newPass;
	}
	@Override
	public String toString() {
		return "ChangePasswordPojo [oldPass=" + oldPass + ", newPass=" + newPass + "]";
	}
	public String getOldPass() {
		return oldPass;
	}
	public void setOldPass(String oldPass) {
		this.oldPass = oldPass;
	}
	public String getNewPass() {
		return newPass;
	}
	public void setNewPass(String newPass) {
		this.newPass = newPass;
	}
}
