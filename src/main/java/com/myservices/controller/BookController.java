package com.myservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myservices.domain.Book;
import com.myservices.mapper.ObjectDomainMapper;
import com.myservices.mysql.entity.BookInfo;
import com.myservices.service.BookService;

import static com.myservices.literals.ApplicationLiteral.APPLICATION_JSON;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/myservices")
public class BookController {
	
	@Autowired
	@Qualifier("bookService")
	private BookService bookService;
	
	@Value("${jdUrl}")
	private String jdUrl;
	
	@Autowired
	private ObjectDomainMapper objectDomainMapper;

	@GetMapping(value={"/book"},consumes={APPLICATION_JSON})
	public void getBook(@RequestParam(value="locale-cd",required=false) String locale,
			@RequestParam(value="book-number",required=false) String bookNumber){
		
		
		
	}
	
	@PostMapping(value={"/save/book"},consumes={APPLICATION_JSON})
	public Map<String,String> saveBook(@RequestBody Book book){
		Map<String,String> responseOp=new HashMap<>();
		
		BookInfo bookInfo=objectDomainMapper.mapperBookDomainObject(book);
		Integer bookId=bookService.saveBook(bookInfo);
		responseOp.put("redirect-url",jdUrl+"/book/"+bookId);
		
		return responseOp;
	}
}
