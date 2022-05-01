package com.dm.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.dm.languages.models.Language;
import com.dm.languages.services.LanguageService;

@Controller
public class LanguageController {
	@Autowired
	private LanguageService languageService;
	
	//INDEX WITH TABLE
	@GetMapping("/languages")
	public String index(@ModelAttribute ("language") Language languageModel, Model model){
		List<Language> languages = languageService.allLanguages();
		model.addAttribute("languages", languages);
		return "index.jsp";
	}
	
	//CREATE 
	@PostMapping("/create")
	public String create(@Valid @ModelAttribute("language") Language languageModel, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Language> languages = languageService.allLanguages();
			model.addAttribute("languages", languages);
			return "index.jsp";
		}
		languageService.createLanguage(languageModel);
		return "redirect:/languages";
	}
	//EDIT/UPDATE REQUIRES TWO ROUTES.
	@GetMapping ("/edit/{id}")
	public String editLanguage(@PathVariable Long id, Model model) {
		Language editLanguage=languageService.languageDetails(id);
		model.addAttribute("editLanguage", editLanguage);
		return "edit.jsp";
	}
	
	@PutMapping("/update/{id}")
	public String updateLanguage(@Valid @ModelAttribute("editLanguage") Language editedLanguage, BindingResult result, @PathVariable Long id) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		
		languageService.updateLanguage(editedLanguage);
		return "redirect:/languages";
	}

	//DELETE: 
	@DeleteMapping("/delete/{id}")
	public String deleteLanguage(@PathVariable Long id) {
		languageService.deleteLanguage(id);
		return "redirect:/languages";
	}

	//SHOW DETAILS: 
	@GetMapping("languageDetails/{id}")
	public String languageDetails(@PathVariable Long id, Model model) {
		Language language = languageService.languageDetails(id);
		model.addAttribute("language", language);
		return "details.jsp";
	}
	
	
}
