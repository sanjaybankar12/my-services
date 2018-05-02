package com.myservices.mysql.dao;

import com.myservices.mysql.entity.BookInfo;

public interface BookDao {

	Integer saveBook(BookInfo bookInfo);
}
