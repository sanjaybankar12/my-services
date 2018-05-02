package com.myservices.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.myservices.domain.AlternateBook;
import com.myservices.domain.Book;
import com.myservices.mysql.entity.AlternateBookInfo;
import com.myservices.mysql.entity.BookInfo;

/**
 * This is mapper class to convert object to domain and vice-versa
 * @author Sanjay Bankar
 *
 */
@Component
public class ObjectDomainMapper {

	public BookInfo mapperBookDomainObject(Book book){
		BookInfo bookInfo=new BookInfo();
		bookInfo.setBookName(book.getBookName());
		bookInfo.setBookNumber(book.getBookNumber());
		bookInfo.setBookDescription(book.getBookDescription());
		
		List<AlternateBookInfo> alternateBooks=new ArrayList<>();
		for(AlternateBook alternateBook: book.getAlternateBooks()){
			AlternateBookInfo alternateBookInfo=new AlternateBookInfo();
			alternateBookInfo.setBookName(alternateBook.getBookName());
			alternateBookInfo.setBookNumber(alternateBook.getBookNumber());
			alternateBookInfo.setBook(bookInfo);
			alternateBooks.add(alternateBookInfo);
		}
		bookInfo.setAlternateBooks(alternateBooks);
		
		return bookInfo; 
	}
}
