package com.inditex.infraestructure.querybuilder;

import java.util.Map;

public class Query {
	
	private String query;
	private Map<String, Object> params;
	
	
	public Query() {}
	
	public Query(String query, Map<String, Object> params) {
		this.query = query;
		this.params = params;
	}
	
	public String getQuery() {
		return query;
	}
	
	public void setQuery(String query) {
		this.query = query;
	}
	
	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

}
