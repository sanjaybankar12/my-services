package com.myservices.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * AlternateBook is domain class
 * 
 * @author Sanjay Bankar
 *
 */
public class AlternateBook {

	@JsonProperty("book-number")
	private String bookNumber;
	
	@JsonProperty("book-name")
	private String bookName;

	/**
	 * @return the bookNumber
	 */
	public String getBookNumber() {
		return bookNumber;
	}

	/**
	 * @param bookNumber the bookNumber to set
	 */
	public void setBookNumber(String bookNumber) {
		this.bookNumber = bookNumber;
	}

	/**
	 * @return the bookName
	 */
	public String getBookName() {
		return bookName;
	}

	/**
	 * @param bookName the bookName to set
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	
}
