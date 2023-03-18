package com.inditex.controller.exception;

import java.io.Serializable;
import java.time.LocalDateTime;

public class InvalidParamExceptionResponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7359984918607873739L;
	
	private String service;
	private LocalDateTime datetime;
	private String message;
	private String paramName;
	private String paramValue;
	
	public InvalidParamExceptionResponse() {}
	
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
