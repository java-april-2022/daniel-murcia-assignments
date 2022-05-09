package com.dm.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.dm.bookclub.models.Book;
import com.dm.bookclub.services.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	
	//NEW BOOK
	@GetMapping("/new")
	public String newBook(
			@ModelAttribute ("newBook") Book book, 
			Model model) {
		return "newbook.jsp";
	}
	
	//CREATE 
	@PostMapping("/create")
	public String createBook(@Valid 
			@ModelAttribute ("newBook") Book book, BindingResult results) {
	if (results.hasErrors()) {
		return "newbook.jsp";
	}
	else {
		bookService.createBook(book);
		return "redirect:/dashboard";
		}
	}
	
	//SHOW DETAILS
	@GetMapping("/show/{id}")
	public String showBookDetails(@PathVariable Long id, Model bookModel, HttpSession session) {
		if (session.getAttribute("loggedInUser")!=null) {
			//Creating a book object with the book details stored inside. 
			Book book = bookService.BookDetails(id);
			// Using the bookModel to render the book object + details onto the JSP page. 
			bookModel.addAttribute("book", book);
			return "details.jsp";
		}
		else {
			return "redirect:/";
		}
	}

	// DELETE A BOOK
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable Long id) {
		bookService.deleteBook(id);
		return "redirect:/dashboard";
	}
	
	//Edit 
	@GetMapping("/edit/{id}")
	public String editBook(@PathVariable Long id, Model model) {
		Book editBook=bookService.BookDetails(id);
		model.addAttribute("editBook", editBook);
		return "edit.jsp";
	}
	//UPDATE: 
	@PutMapping("/update/{id}")
	public String updateBook(@Valid @ModelAttribute("editBook") Book editedBook, BindingResult result, @PathVariable Long id) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		bookService.updateBook(editedBook);
		return "redirect:/dashboard";
	}	
	
}
