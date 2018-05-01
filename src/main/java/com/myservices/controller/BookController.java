package com.myservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.myservices.literals.ApplicationLiteral.APPLICATION_JSON;

@RestController
@RequestMapping("/v1/myservices")
public class BookController {

	@GetMapping(value={"/book"},consumes={APPLICATION_JSON})
	public void getBook(@RequestParam(value="locale-cd",required=false) String locale,
			@RequestParam(value="book-number",required=false) String bookNumber){
		
		
		
	}
}
