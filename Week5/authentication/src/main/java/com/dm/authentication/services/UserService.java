package com.dm.authentication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.dm.authentication.models.LoginUser;
import com.dm.authentication.models.User;
import com.dm.authentication.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	
	//To-do : write register and login methods. 
	public User register(User newUser, BindingResult result) {
		// To do: additional validations.
		return null;
	}
	public User login(LoginUser newLoginObject, BindingResult result) {
		//To-do: additional validations. 
		
		return null;
	}
	
	//Registration Logic:
	//Is the email already taken?
	//Does the entered password match the confirmation password?
	///Hashing password and creating a user if no errors
	
	// Login Logic
	// Does a user with that email exist in the DB? 
	// If so, is the password the right password for that email? 
}
