package com.myservices.service;

import com.myservices.mysql.entity.BookInfo;

public interface BookService {

	Integer saveBook(BookInfo bookInfo);
}
