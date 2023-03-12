package com.inditex.infraestructure.querybuilder;

public class FieldsResultBuilder {
	
	private static String SPACE = " ";
	private static String FIELDS = "{results}";
	private static String TABLE = "{table}";
	private static String COLUMN = "{column}";
	private static String ALIAS = "{alias}";
	
	private static String AS = "AS";
	private static String FIELD = TABLE + "." + COLUMN + ",";
	private static String FIELD_ALIAS = TABLE + "." + COLUMN + SPACE + AS + SPACE + ALIAS + ",";
	private static String FIELDS_RESULT = "SELECT" + SPACE + FIELDS;
	private static String SUM = "*";
	private static String SUBSTRACT = "*";
	private static String MULTIPLY = "*";
	private static String DIVIDE = "*";
	
	private String query;
	private String results;
	
	
	public FieldsResultBuilder(String table, String column) {
		this.query = FIELDS_RESULT;
		this.results = FIELD.replace(TABLE, table).replace(COLUMN, column);
	}
	
	public FieldsResultBuilder(String table, String column, String alias) {
		this.query = FIELDS_RESULT;
		this.results = FIELD_ALIAS.replace(TABLE, table).replace(COLUMN, column).replace(ALIAS, alias);
	}
	
	public FieldsResultBuilder result(String table, String column) {
		this.results = this.results.concat(FIELD.replace(TABLE, table).replace(COLUMN, column));
		return this;
	}
	
	public FieldsResultBuilder result(String table, String column, String alias) {
		this.results = this.results.concat(FIELD_ALIAS.replace(TABLE, table).replace(COLUMN, column).replace(ALIAS, alias));
		return this;
	}
	
	public FieldsResultBuilder multiply(String table, String column, String tableMultiply, String columnMultiply, String alias) {
		return buildOperation(table, column, tableMultiply, columnMultiply, alias, MULTIPLY);
	}
	
	public FieldsResultBuilder sum(String table, String column, String tableMultiply, String columnMultiply, String alias) {
		return buildOperation(table, column, tableMultiply, columnMultiply, alias, SUM);
	}
	
	public FieldsResultBuilder divide(String table, String column, String tableMultiply, String columnMultiply, String alias) {
		return buildOperation(table, column, tableMultiply, columnMultiply, alias, DIVIDE);
	}
	
	public FieldsResultBuilder substract(String table, String column, String tableMultiply, String columnMultiply, String alias) {
		return buildOperation(table, column, tableMultiply, columnMultiply, alias, SUBSTRACT);
	}
	
	public FromBuilder from() {
		this.results = this.results.substring(0, this.results.length() - 1);
		this.query = this.query.replace(FIELDS, this.results);
		return new FromBuilder(this.query);
	}
	
	private FieldsResultBuilder buildOperation(String table, String column, String tableOperation, String columnOperation, String alias, String operation) {
		this.results = this.results.concat(FIELD.replace(TABLE, table).replace(COLUMN, column));
		this.results = this.results.substring(0, this.results.length() - 1);
		this.results = this.results.concat(operation);
		this.results = this.results.concat(FIELD_ALIAS.replace(TABLE, tableOperation).replace(COLUMN, columnOperation)).replace(ALIAS, alias);
		return this;
	
	}
}
