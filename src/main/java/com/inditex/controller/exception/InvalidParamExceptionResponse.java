package com.inditex.controller.exception;

import java.time.LocalDateTime;

public class InvalidParamExceptionResponse {
	
	private final String service;
	private final LocalDateTime datetime;
	private final String message;
	private final String paramName;
	private final String paramValue;
	
	public InvalidParamExceptionResponse(String service, String message, String paramName, String paramValue) {
		this.service = service;
		this.datetime = LocalDateTime.now();
		this.message = message;
		this.paramName = paramName;
		this.paramValue = paramValue;
	}

	public String getService() {
		return service;
	}

	public LocalDateTime getDatetime() {
		return datetime;
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
