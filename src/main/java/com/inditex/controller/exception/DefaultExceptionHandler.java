package com.inditex.controller.exception;

import static com.inditex.controller.exception.HttpErrorCodes.PARAM_FORMAT_ERROR;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.inditex.domain.InvalidParamException;

@ControllerAdvice
public class DefaultExceptionHandler {
	
	private static Logger logger = LogManager.getLogger(DefaultExceptionHandler.class);
	
	private final String service;
	
	public DefaultExceptionHandler(@Value("${spring.application.name}") String service) {
		this.service = service;
	}
	
	@ExceptionHandler(value = InvalidParamException.class)
	public ResponseEntity<InvalidParamExceptionResponse> clientInvalid(InvalidParamException exception){
		InvalidParamExceptionResponse body = new InvalidParamExceptionResponse(this.service,
				exception.getMessage(), 
				exception.getParamName(), 
				exception.getParamValue());
		logger.error(exception);
		return ResponseEntity.status(PARAM_FORMAT_ERROR.getCode()).body(body);
	}
	
}
