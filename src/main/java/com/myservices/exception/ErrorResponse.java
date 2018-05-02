package com.myservices.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author Sanjay Bankar
 *
 */
public class ErrorResponse {

	@JsonProperty("code")
	private Integer errorCode;
	
	@JsonProperty("message")
	private String errorMessage;

	/**
	 * @return the errorCode
	 */
	public Integer getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
}
