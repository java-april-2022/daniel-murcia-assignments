package com.dm.mvc.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dm.mvc.models.Book;
import com.dm.mvc.services.BookService;

@Controller
public class BookController {
	
	@Autowired 
	private BookService bookService;
	
	@GetMapping("/")
	public String index(Model bookModel) {
//		List<Book> books = bookService.allBooks();
//		bookModel.addAttribute("allBooks",books);
		return "show.jsp";
	}

	@GetMapping("/books/{id}")
	public String show(@PathVariable("id") Long id, Model bookModel) {
		Book book = bookService.findBook(id);
		bookModel.addAttribute("book",book);
		return "show.jsp";
	}
	


}
