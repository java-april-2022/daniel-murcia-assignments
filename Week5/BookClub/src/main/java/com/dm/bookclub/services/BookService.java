package com.dm.bookclub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dm.bookclub.models.Book;
import com.dm.bookclub.repositories.BookRepository;



@Service
public class BookService {

	@Autowired
	private BookRepository bookRepo;

	
	//All Books
	public List<Book> getAllBooks(){
		return bookRepo.findAll();
	}
	//Create Book
	public Book createBook(Book Book) {
		return bookRepo.save(Book);
	}
	//updates the book 
	public Book updateBook(Book b) {
	    return bookRepo.save(b);
	}

	//show details 
	public Book BookDetails(Long id) {
		return bookRepo.findById(id).orElse(null);
	}
	
	//Delete Book 
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}
	
	
	

}
