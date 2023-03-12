package com.inditex.controller.exception;

public class ParamFormatExceptionResponse {
	
	private final String message;
	private final String paramName;
	private final String paramValue;
	
	public ParamFormatExceptionResponse(String message, String paramName, String paramValue) {
		this.message = message;
		this.paramName = paramName;
		this.paramValue = paramValue;
	}

	public String getMessage() {
		return message;
	}
	
	public String getParamName() {
		return paramName;
	}

	public String getParamValue() {
		return paramValue;
	}

}
