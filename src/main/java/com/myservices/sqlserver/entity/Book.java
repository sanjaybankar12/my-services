package com.myservices.sqlserver.entity;

import java.util.List;

import javax.persistence.*;

/**
 * This Book class is entity class to store,retrieve,update Book Details.
 * 
 * @author Sanjay Bankar
 *
 */

@Entity
@Table(name="BOOK_INFO")
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID",nullable=false)
	private Integer id;
	
	@Column(name="BOOK_NBR",nullable=false)
	private String bookNumber;
	
	@Column(name="BOOK_NAME",nullable=false)
	private String bookName;
	
	@Column(name="BOOK_DESC",nullable=false)
	private String bookDescription;
	
	@OneToMany(mappedBy="book",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<AlternateBook> alternateBooks;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

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
