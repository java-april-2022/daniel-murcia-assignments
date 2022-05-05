package com.dm.userprojects.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dm.userprojects.models.LoginUser;
import com.dm.userprojects.models.User;
import com.dm.userprojects.services.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;
	
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
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session) {
		//check if user is in session; 
		if(session.getAttribute("loggedInUser")!=null){
			return "dashboard.jsp";
		}
		else {
			return "redirect:/";
		}
	}
}
