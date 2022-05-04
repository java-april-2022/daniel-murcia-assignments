package com.dm.favcookie.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dm.favcookie.models.Cookie;
import com.dm.favcookie.services.CookieService;


@Controller
@RequestMapping("/cookie")
public class CookieController {

	@Autowired
	private CookieService service;
	
	@GetMapping("")
	public String add(
			Model model
			) {
		model.addAttribute("items", this.service.all());
		return "cookies.jsp";
	}
	
	
	@GetMapping("/add")
	public String getAddForm(Model model) {
		model.addAttribute("item", new Cookie());
		return "addCookie.jsp";
	}
	
	
	@PostMapping("/add")
	public String add(
			@ModelAttribute("cookie") Cookie cookie,
			BindingResult result, 
			Model model,
			RedirectAttributes redirectAttributes
			) {
		return "addCookie.jsp";
	}
	
}
