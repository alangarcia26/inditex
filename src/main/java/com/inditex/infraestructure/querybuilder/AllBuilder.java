package com.inditex.infraestructure.querybuilder;

public class AllBuilder {
	
	private static String ALL = "SELECT *";
	
	private String query;
	
	public AllBuilder() {
		this.query = ALL;
	}
	
	public FromBuilder from() {
		return new FromBuilder(this.query);
	}

}
