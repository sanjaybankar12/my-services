package com.myservices.mysql.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.*;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myservices.mysql.entity.BookInfo;

@Repository("bookDao")
public class BookDaoImpl implements BookDao {

	@PersistenceContext(unitName="mysql")
	private EntityManager entityManager;
	
	@Override
	@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,rollbackFor=Throwable.class)
	public Integer saveBook(BookInfo bookInfo) {

		entityManager.persist(bookInfo);
		entityManager.flush();		
		
		Query query=entityManager.createQuery("select b.id from BookInfo b where b.bookNumber=:bookNumber");
		query.setParameter("bookNumber", bookInfo.getBookNumber());
		Integer bookId=(Integer)query.getSingleResult();

		return bookId;
	}

}
