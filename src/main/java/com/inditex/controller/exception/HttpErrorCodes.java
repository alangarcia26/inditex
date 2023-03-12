package com.inditex.controller.exception;

public enum HttpErrorCodes {
	
	PARAM_FORMAT_ERROR(432),
	PARAM_INVALID(402);
	
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
