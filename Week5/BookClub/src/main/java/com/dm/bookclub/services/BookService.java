package com.dm.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dm.bookclub.models.Book;
import com.dm.bookclub.models.User;
import com.dm.bookclub.repositories.BookRepository;


@Service
public class BookService {

	@Autowired
	private BookRepository bookRepo;

	
	//All Books
	public List<Book> getAllBooks(){
		return bookRepo.findAll();
	}
	
	//One User's Books 
	public List<Book> myBooks(User user){
		return bookRepo.findByUserIdIs(user.getId());
	}
	
	//Create 
	public Book createBook(Book Book) {
		return bookRepo.save(Book);
	}
	//Update
	public Book updateBook(Book b) {
	    return bookRepo.save(b);
	}

	//Details 
	public Book BookDetails(Long id) {
		return bookRepo.findById(id).orElse(null);
	}
	
	//Delete  
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}
	
	
	//All Unborrowed Books:
	public List<Book> unborrowedBooks(User user){
		return bookRepo.findByBorrowerOrUserIdIs(null, user.getId());
	}
	
	//All Borrowed Books: 
	public List<Book> borrowedBooks(User user){
		return bookRepo.findByBorrowerIdIs(user.getId());
	}
	

	//Borrow Book 
	public void borrowBook(Book book, User user) {
		book.setBorrower(user);
		bookRepo.save(book);
	}
	
	//Unborrow Book 
	public void unborrowBook(Book book, User user) {
		book.setBorrower(null);
		bookRepo.save(book);
	}

	
	//Find book 
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		}else {
			return null;
		}
	}
	

	

}
