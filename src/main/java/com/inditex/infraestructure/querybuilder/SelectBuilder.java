package com.inditex.infraestructure.querybuilder;


public class SelectBuilder {
	
	public SelectBuilder() {}
	
	public FieldsResultBuilder result(String table, String column) {
		return new FieldsResultBuilder(table, column);
	}
	
	public FieldsResultBuilder result(String table, String column, String alias) {
		return new FieldsResultBuilder(table, column, alias);
	}
	
	public AllBuilder all() {
		return new AllBuilder();
	}
	
}
