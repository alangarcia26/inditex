package com.inditex.controller.exception;

import static com.inditex.controller.exception.HttpErrorCodes.PARAM_FORMAT_ERROR;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.inditex.domain.ParamFormatException;

@ControllerAdvice
public class DefaultExceptionHandler {
	
	private static Logger logger = LogManager.getLogger(DefaultExceptionHandler.class);
	
	@ExceptionHandler(value = ParamFormatException.class)
	public ResponseEntity<ParamFormatExceptionResponse> clientInvalid(ParamFormatException exception){
		ParamFormatExceptionResponse body = new ParamFormatExceptionResponse(exception.getMessage(), 
				exception.getParamName(), 
				exception.getParamValue());
		logger.error(exception);
		return ResponseEntity.status(PARAM_FORMAT_ERROR.getCode()).body(body);
	}
	
}
