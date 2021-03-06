package com.dm.bookclub.controllers;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMapping;

import com.dm.bookclub.models.Book;
import com.dm.bookclub.models.LoginUser;
import com.dm.bookclub.models.User;
import com.dm.bookclub.services.BookService;
import com.dm.bookclub.services.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	@Autowired
	private BookService bookService;
	
	@GetMapping("/")
	public String index(
			//We need to provide BOTH model attributes in the root route. 
			@ModelAttribute("newUser") User user, 
			@ModelAttribute("newLogin") LoginUser loginUser) {
		return "index.jsp";
	}
	
	
	//*********Register a User************
	@PostMapping("/registration")
	public String registerUser(@Valid @ModelAttribute("newUser") User user,
			BindingResult result, HttpSession session, @ModelAttribute("newLogin") LoginUser loginUser) {
		//validate user
		userService.validate(user, result);
		if(result.hasErrors()) {
			return "index.jsp";
		}
		//register user
		userService.registerUser(user);
		
		//put user in session
		session.setAttribute("loggedInUser", user);
		return "redirect:/dashboard";
	}
	
	//*********Login***************
	@PostMapping("/login")
	public String loginUser(@Valid @ModelAttribute("newLogin") LoginUser loginUser, 
			BindingResult results, 
			HttpSession session, 
			@ModelAttribute("newUser") User user) {
		
		// authenticate user
		userService.authenticateUser(loginUser, results);
		if (results.hasErrors()) {
			return "index.jsp";
		}
		User loggedInUser=userService.findByEmail(loginUser.getEmail());
		
		
		// put user in session 
		session.setAttribute("loggedInUser", loggedInUser);
		
		return "redirect:/dashboard";
	}
	
	//********Logout**********
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	//*********Dashboard***********
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
		//check if user is in session; 
		if(session.getAttribute("loggedInUser")!=null){
			List<Book> books = bookService.getAllBooks();
			model.addAttribute("books", books);
			return "dashboard.jsp";
		}
		else {
			return "redirect:/";
		}
		
	}

	//*******Bookmarket***********
	@GetMapping("/bookbroker")
	public String bookBroker(HttpSession session, Model model) {
		//check if user is in session; 
		if(session.getAttribute("loggedInUser")!=null){
			User loggedInUser = (User)session.getAttribute("loggedInUser"); 
			User userLoggedIn=userService.findById(loggedInUser.getId());
			model.addAttribute("userLoggedIn", userLoggedIn);
			List<Book> availableBooks = bookService.unborrowedBooks(loggedInUser);
			List<Book> borrowedBooks = bookService.borrowedBooks(loggedInUser);
			model.addAttribute("availableBooks", availableBooks);
			model.addAttribute("borrowedBooks", borrowedBooks);
			return "bookbroker.jsp";
		}
		else {
			return "redirect:/";
		}
	}
	
	//Borrow a book 
	@RequestMapping("/borrow/{bookID}")
	public String borrowBook(@PathVariable ("bookID") Long bookID, HttpSession session, Model model) {

		System.out.println("book borrowed");
		User loggedInUser = (User)session.getAttribute("loggedInUser");
//		User userLoggedIn=userService.findById(loggedInUser.getId());
		bookService.borrowBook(bookService.findBook(bookID), loggedInUser);
		return "redirect:/bookbroker";
			
	}

	
	//Return a book 
	@RequestMapping("/return/{bookID}")
	public String returnBook(@PathVariable ("bookID") Long bookID, HttpSession session, Model model) {

		System.out.println("book returned");
		User loggedInUser = (User)session.getAttribute("loggedInUser");
//		User userLoggedIn=userService.findById(loggedInUser.getId());
		bookService.unborrowBook(bookService.findBook(bookID), loggedInUser);
		return "redirect:/bookbroker";
			
	}
	
	

}
