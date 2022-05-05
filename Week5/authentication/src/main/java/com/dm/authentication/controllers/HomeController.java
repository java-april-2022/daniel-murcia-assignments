package com.dm.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dm.authentication.models.LoginUser;
import com.dm.authentication.models.User;

@Controller
public class HomeController {

	//add once service is implemented: 
	//@Autowired
	// private UserService userServ;
	
	@GetMapping("/")
	public String index(Model model) {
		//bind empty User and LoginUser objects to the JSP 
		//to capture the form input
		
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "index.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
		//To do later: -- call a register method in the service 
		// to do some extra validations and create a new user!
		
		// TO-DO - Reject values or register if no errors:
        
        // Reject if email is taken (present in database)
        // Reject if password doesn't match confirmation
        
        // Return null if result has errors
    
        // Hash and set password, save user to database
		
		if(result.hasErrors()) {
			//be sure to send in the empty LoginUser before 
			//re rendering the page 
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}
		
		//To-do later: store their ID from the DB in session, aka log them in. 
		
		return "redirect:/";
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
		
		// add once service is implemented:
		// User user = userServ.login(newLogin, result);
		
		
        // TO-DO - Reject values:
        
    	// Find user in the DB by email
        // Reject if NOT present
        
        // Reject if BCrypt password match fails
    
        // Return null if result has errors
        // Otherwise, return the user object
		
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "index.jsp";
		}
		
		//To-do later: store their ID from the DB in session-- aka log them in. 
		
		return "redirect:/";
	}
	
	
}
