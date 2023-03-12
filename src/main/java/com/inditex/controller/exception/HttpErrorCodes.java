package com.inditex.controller.exception;

public enum HttpErrorCodes {
	
	INVALID_PARAM_ERROR(432);
	
	private Integer code;
	
	HttpErrorCodes(int code) {
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

}
