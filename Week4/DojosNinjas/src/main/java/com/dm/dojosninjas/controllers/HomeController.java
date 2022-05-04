package com.dm.dojosninjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.dm.dojosninjas.models.Dojo;
import com.dm.dojosninjas.models.Ninja;
import com.dm.dojosninjas.services.MainService;

@Controller 
public class HomeController {
	@Autowired
	private MainService mainService;
	
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("ninjas", mainService.getAllNinjas());
		return "index.jsp";
	}
//New dojo - get & post routes
	
	
	@GetMapping("/newDojo")
	public String dojo(@ModelAttribute("newDojo") Dojo dojo) {
		return "new_dojo.jsp";
	}
	
	@PostMapping("/createDojo")
	public String createDojo(@ModelAttribute("newDojo") Dojo dojo) {
		mainService.createDojo(dojo);
		return "redirect:/";
	}

//New Fitness Class - get & post routes 
	
	@GetMapping("/newNinja")
	public String newNinja(
			@ModelAttribute ("newNinja") Ninja ninja, 
			Model model) {
		model.addAttribute("dojos", mainService.getAllDojos());
		return "new_ninja.jsp";
	}
	
	@PostMapping("/createNinja")
	public String createNinja(
			@ModelAttribute ("newNinja") Ninja ninja) {
	mainService.createNinja(ninja);
	return "redirect:/";
	}
	
	@GetMapping("/show/{id}")
	public String showDojo(@PathVariable Long id, Dojo dojo, Model model) {
		dojo = mainService.dojoDetails(id);
		model.addAttribute("ninjas", mainService.getAllByDojoId(id));
		model.addAttribute("dojo", dojo);
		return "show.jsp";
	}


}
