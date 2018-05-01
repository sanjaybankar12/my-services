package com.myservices.sqlserver.entity;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BOOK_INFO")
public class AlternateBook {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID",nullable=false)
	private Integer id;
	
	@Column(name="BOOK_NBR",nullable=false)
	private String bookNumber;
	
	@Column(name="BOOK_NAME",nullable=false)
	private String bookName;
	
	@ManyToOne
	@JoinColumn(name="BOOK_ID")
	private Book book;

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
	
	
}
