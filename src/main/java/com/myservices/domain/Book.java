package com.myservices.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This BookOP is domain class
 * 
 * @author Sanjay Bankar
 *
 */
public class Book {

	@JsonProperty("book-number")
	private String bookNumber;
	
	@JsonProperty("book-name")
	private String bookName;
	
	@JsonProperty("book-desc")
	private String bookDescription;
	
	@JsonProperty("alternate-book")
	private List<AlternateBook> alternateBooks;

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

	/**
	 * @return the bookDescription
	 */
	public String getBookDescription() {
		return bookDescription;
	}

	/**
	 * @param bookDescription the bookDescription to set
	 */
	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}

	/**
	 * @return the alternateBooks
	 */
	public List<AlternateBook> getAlternateBooks() {
		return alternateBooks;
	}

	/**
	 * @param alternateBooks the alternateBooks to set
	 */
	public void setAlternateBooks(List<AlternateBook> alternateBooks) {
		this.alternateBooks = alternateBooks;
	}
	
}
