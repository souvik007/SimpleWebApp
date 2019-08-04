package com.souvy.app.model;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class ValidationResponse {
	
	private String status;
	private Map<String,String> errors;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Map<String, String> getErrors() {
		return errors;
	}
	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}
	@Override
	public String toString() {
		return "validationResponse [status=" + status + ", errors=" + errors + "]";
	}
	public ValidationResponse(String status, Map<String, String> errors) {
		super();
		this.status = status;
		this.errors = errors;
	}
	public ValidationResponse() {
		super();
	}
	
}
