package com.souvy.app.model.service;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import com.souvy.app.model.SessionDetails;

@Component
public class Logout {
	private String logoutMessage;

	public String logoutLogic(HttpSession httpSession) {
		if(SessionDetails.sessionList.containsKey(httpSession.hashCode())) {
			SessionDetails.sessionList.remove(httpSession.hashCode());
			//httpSession.invalidate();
			logoutMessage = "logged out successfully";
		}
		else {
			logoutMessage = "not logged in";
		}
		return logoutMessage;
	}
}
