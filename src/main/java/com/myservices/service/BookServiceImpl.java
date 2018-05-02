package com.myservices.service;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myservices.exception.ConstraintException;
import com.myservices.exception.DataPersistenceException;
import com.myservices.mysql.dao.BookDao;
import com.myservices.mysql.entity.BookInfo;

@Service("bookService")
@Transactional
public class BookServiceImpl implements BookService {

	@Autowired
	@Qualifier("bookDao")
	private BookDao bookDao;
	
	@Override
	public Integer saveBook(BookInfo bookInfo) {
		Integer bookId=null;
		try{
		 bookId= bookDao.saveBook(bookInfo);
		}catch(ConstraintViolationException ce){
			throw new ConstraintException("Book number already registered..!!",null,"book-number");
		}catch(Exception e){
			throw new DataPersistenceException(e.getMessage());
		}
		return bookId;
	}

}
