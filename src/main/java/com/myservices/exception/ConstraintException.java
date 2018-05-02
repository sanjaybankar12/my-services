package com.myservices.exception;

import java.sql.SQLException;

import org.hibernate.exception.ConstraintViolationException;

public class ConstraintException extends ConstraintViolationException {

	public ConstraintException(String message, SQLException root, String constraintName) {
		super(message, root, constraintName);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
