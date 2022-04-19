package com.dm.demo.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/students")
	public String students(Model studentModel ) {
		String student ="Brody";
		String city = "Chicago";
		studentModel.addAttribute("studentName", student);
		studentModel.addAttribute("studentCity", city);
		
		return "student.jsp";
	
}
	@RequestMapping("/stacks")
	public String stacks(Model model) {
		ArrayList<String> stacks = new ArrayList<>();
		stacks.add("Java");
		stacks.add("Python");
		stacks.add("MERN");
		//Passing ArrayList as object into the model: 
		model.addAttribute("myStacks", stacks); //<<this is the arraylist
		return "stacks.jsp";
	}
}
