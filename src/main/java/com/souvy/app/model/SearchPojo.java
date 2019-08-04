package com.souvy.app.model;

import org.springframework.stereotype.Component;

@Component
public class SearchPojo {

	private String searchQuery;
	private String searchCriteria;
	public String getSearchQuery() {
		return searchQuery;
	}
	public void setSearchQuery(String searchQuery) {
		this.searchQuery = searchQuery;
	}
	public String getSearchCriteria() {
		return searchCriteria;
	}
	public void setSearchCriteria(String searchCriteria) {
		this.searchCriteria = searchCriteria;
	}
	public SearchPojo(String searchQuery, String searchCriteria) {
		super();
		this.searchQuery = searchQuery;
		this.searchCriteria = searchCriteria;
	}
	public SearchPojo() {
		super();
	}
	
}
