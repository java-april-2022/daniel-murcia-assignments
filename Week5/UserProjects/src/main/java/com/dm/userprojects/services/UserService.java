package com.dm.userprojects.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import com.dm.userprojects.models.LoginUser;
import com.dm.userprojects.models.User;
import com.dm.userprojects.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	//Validate user for - duplicate email and password mismatch
	public void validate(User newUser, Errors errors) {
		// Password Matching
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			errors.rejectValue("password", "mismatch", "Password does not match.");
		}
		//Email - Check if email is a Duplicate
		if(userRepo.findByEmail(newUser.getEmail())!=null) {
			errors.rejectValue("email", "unique", "Email is already taken.");
		}
	}
	
	//Hash user's password and add to database
	public User registerUser(User newUser) {
		String hashedPass=BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashedPass);
		userRepo.save(newUser);
		return null;
	}
	
	// find user by email
	public User findByEmail(String email) {
		return userRepo.findByEmail(email);
	}
	
	//find user by id 
	public User findById(Long id) {
		return userRepo.findById(id).orElse(null);
	}
	
	//Authenticate user 
	public boolean authenticateUser(LoginUser newLogin, Errors errors) {
		//first find the user by email
		User user = userRepo.findByEmail(newLogin.getEmail());
		// if we can't find user by email, return false
		if(user==null) {
			errors.rejectValue("email", "missingEmail", "Email not found");
			return false;
		} else {
			// if user is found check if the passwords match, return true, else, return false. 
			if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())){
				errors.rejectValue("password", "matches", "Invalid password!");
				return false;
			}
		}
			
		return true;
	}
}
