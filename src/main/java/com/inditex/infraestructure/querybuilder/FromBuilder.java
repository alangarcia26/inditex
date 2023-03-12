package com.inditex.infraestructure.querybuilder;

public class FromBuilder {
	
	private static String SPACE = " ";
	private static String SCHEMA = "{schema}";
	private static String TABLE = "{table}";
	
	private static String FROM = "FROM" + SPACE + SCHEMA + "." + TABLE;
	
	private String query;
	
	
	public FromBuilder(String query) {
		this.query = query.concat(SPACE).concat(FROM);
	}
	
	
	public FromBuilder schema(String schema) {
		this.query = this.query.replace(SCHEMA, schema);
		return this;
	}
	
	
	public FromBuilder table(String table) {
		this.query = this.query.replace(TABLE, table);
		return this;
	}
	
	
	public WhereBuilder where() {
		return new WhereBuilder(build());
	}
	

	public String build() {
		return this.query;
	}

}
