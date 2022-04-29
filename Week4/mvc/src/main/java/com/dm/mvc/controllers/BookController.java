package com.dm.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.dm.mvc.models.Book;
import com.dm.mvc.services.BookService;

@Controller
public class BookController {
	
	@Autowired 
	private BookService bookService;
	
	@GetMapping("/books/new")
	public String newBook(@ModelAttribute("book") Book book) {
		return "/books/new.jsp";
	}
	
	@PostMapping("/books")
	public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		bookService.createBook(book);
		if(result.hasErrors()) {
			return "/books/new.jsp";
		}
		return "redirect:/books";
	}
	
	@GetMapping("/books")
    public String index(Model model) {
        List<Book> books = bookService.allBooks();
        model.addAttribute("books", books);
        return "/books/index.jsp";
    }

	@GetMapping("/books/{id}")
	public String show(@PathVariable("id") Long id, Model bookModel) {
		Book book = bookService.findBook(id);
		bookModel.addAttribute("book",book);
		return "show.jsp";
	}
	
}
