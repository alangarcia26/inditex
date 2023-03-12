package com.inditex.domain;

public class ParamFormatException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3720280809506888731L;
	
	private final String paramName;
	private final String paramValue;
	
	public ParamFormatException(String message, String paramName, String paramValue) {
		super(message);
		this.paramName = paramName;
		this.paramValue = paramValue;
	}

	public String getParamName() {
		return paramName;
	}

	public String getParamValue() {
		return paramValue;
	}
	
}
