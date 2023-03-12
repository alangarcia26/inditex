package com.inditex.infraestructure.querybuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WhereBuilder {
	
	private static String SPACE = " ";
	private static String TABLE = "{table}";
	private static String COLUMN = "{column}";
	private static String PARAM = "?";

	private static String WHERE = "WHERE";
	private static String AND = "AND";
	private static String OR = "OR";
	private static String IS_NULL = TABLE + "." + COLUMN + SPACE + "IS NULL";
	private static String IS_NOT_NULL = TABLE + "." + COLUMN + SPACE + "IS NOT NULL";
	private static String EQUAL = TABLE + "." + COLUMN + "=:" + PARAM;
	private static String NOT_EQUAL = TABLE + "." + COLUMN + "!=:" + PARAM;
	private static String LESSER = TABLE + "." + COLUMN + "<:" + PARAM;
	private static String GREATER = TABLE + "." + COLUMN + ">:" + PARAM;
	private static String LESSER_EQUAL = TABLE + "." + COLUMN + "<=:" + PARAM;
	private static String GREATER_EQUAL = TABLE + "." + COLUMN + ">=:" + PARAM;
	private static String LIKE = TABLE + "." + COLUMN + SPACE +  "LIKE " + "%:" + PARAM + "%";
	
	private String query;
	private String logicOperator;
	private Map<String, Object> params;
	private boolean hasCondition;
	
	
	public WhereBuilder(String query) {
		this.query = query.concat(SPACE).concat(WHERE);
		this.hasCondition = false;
		this.logicOperator = "";
	}
	
	public WhereBuilder(String query, Map<String, Object> params) {
		this.query = query.concat(SPACE).concat(WHERE);
		this.params = params;
		this.hasCondition = false;
		this.logicOperator = "";
	}
	
	
	public WhereBuilder and() {
		this.logicOperator = SPACE.concat(AND);
		return this;
	}
	
	
	public WhereBuilder or() {
		this.logicOperator = SPACE.concat(OR);
		return this;
	}
	
	
	public WhereBuilder isNull(String table, String column) {
		this.hasCondition = true;
		return buildConditionWithoutParam(IS_NULL.replace(TABLE, table)
				.replace(COLUMN, column));
	}
	
	
	public WhereBuilder isNotNull(String table, String column) {
		this.hasCondition = true;
		return buildConditionWithoutParam(IS_NOT_NULL.replace(TABLE, table)
				.replace(COLUMN, column));
	}
	
	
	public WhereBuilder equal(String table, String column, String paramName, Object param) {
		return buildConditionWithParam(paramName, param, EQUAL.replace(TABLE, table)
				.replace(COLUMN, column).replace(PARAM, paramName));
	}
	
	
	public WhereBuilder notEqual(String table, String column, String paramName, Object param) {
		return buildConditionWithParam(paramName, param, NOT_EQUAL.replace(TABLE, table)
				.replace(COLUMN, column).replace(PARAM, paramName));
	}
	
	
	public WhereBuilder lesser(String table, String column, String paramName, Object param) {
		return buildConditionWithParam(paramName, param, LESSER.replace(TABLE, table)
				.replace(COLUMN, column).replace(PARAM, paramName));
	}
	
	
	public WhereBuilder greater(String table, String column, String paramName, Object param) {
		return buildConditionWithParam(paramName, param, GREATER.replace(TABLE, table)
				.replace(COLUMN, column).replace(PARAM, paramName));
	}
	
	
	public WhereBuilder lesserEqual(String table, String column, String paramName, Object param) {
		return buildConditionWithParam(paramName, param, LESSER_EQUAL.replace(TABLE, table)
				.replace(COLUMN, column).replace(PARAM, paramName));
	}
	
	
	public WhereBuilder greaterEqual(String table, String column, String paramName, Object param) {
		return buildConditionWithParam(paramName, param, GREATER_EQUAL.replace(TABLE, table)
				.replace(COLUMN, column).replace(PARAM, paramName));
	}
	
	
	public WhereBuilder like(String table, String column, String paramName, Object param) {
		return buildConditionWithParam(paramName, param, LIKE.replace(TABLE, table)
				.replace(COLUMN, column).replace(PARAM, paramName));
	}
	
	
	public Query build() {
		if(!this.hasCondition) {
			this.query = this.query.substring(0, this.query.length() - WHERE.length() - SPACE.length());
		}
		return createQuery();
	}
	
	
	private WhereBuilder buildConditionWithoutParam(String subquery) {
		this.query = this.query.concat(this.logicOperator).concat(SPACE).concat(subquery);
		return this;
	}
	
	
	private WhereBuilder buildConditionWithParam(String name, Object param, String subquery) {
		if(Objects.nonNull(param)) {
			this.hasCondition = true;
			this.query = this.query.concat(this.logicOperator).concat(SPACE).concat(subquery);
			buildParam(name, param);
		}
		this.logicOperator = "";
		return this;
	}
	
	
	private void buildParam(String name, Object param) {
		if(Objects.isNull(this.params)) {
			this.params = new HashMap<String, Object>();
		}
		this.params.put(name, param);
	}
	
	
	private Query createQuery() {
		Query query = new Query();
		query.setQuery(this.query);
		query.setParams(this.params);
		return query;
	}
	
}
