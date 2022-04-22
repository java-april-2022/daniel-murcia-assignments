package com.dm.omikuji.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class MainController {
	
	@GetMapping("/omikuji")
	public String index() {
		return "index.jsp";
	}
	
	
	@PostMapping("/omikuji/show")
	public String show(@RequestParam Integer num, @RequestParam String city, @RequestParam String person, @RequestParam String hobby, @RequestParam String livingThing, @RequestParam String somethingNice, Model viewModel) {
		
		viewModel.addAttribute("num", num);
		viewModel.addAttribute("city", city);
		viewModel.addAttribute("person", person);
		viewModel.addAttribute("hobby", hobby);
		viewModel.addAttribute("livingThing", livingThing);
		viewModel.addAttribute("somethingNice", somethingNice);
		return "show.jsp";
	}
	
	
	

}
