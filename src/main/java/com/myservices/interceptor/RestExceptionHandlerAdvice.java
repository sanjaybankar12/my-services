package com.myservices.interceptor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.myservices.exception.ClientException;
import com.myservices.exception.ConstraintException;
import com.myservices.exception.DataPersistenceException;
import com.myservices.exception.ErrorResponse;

@ControllerAdvice
public class RestExceptionHandlerAdvice {

	@ExceptionHandler
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse handlerRestException(ConstraintException ConstraintException){
		ErrorResponse errorResponse=new ErrorResponse();
		errorResponse.setErrorCode(400);
		errorResponse.setErrorMessage(ConstraintException.getMessage());
		
		return errorResponse;
	}
	@ExceptionHandler
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorResponse handlerRestException(DataPersistenceException dataPersistenceException){
		ErrorResponse errorResponse=new ErrorResponse();
		errorResponse.setErrorCode(500);
		errorResponse.setErrorMessage(dataPersistenceException.getMessage());
		
		return errorResponse;
	}
	
	@ExceptionHandler
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse handlerRestException(ClientException clientException){
		ErrorResponse errorResponse=new ErrorResponse();
		errorResponse.setErrorCode(400);
		errorResponse.setErrorMessage(clientException.getMessage());
		
		return errorResponse;
	}
}
