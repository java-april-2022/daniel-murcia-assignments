package com.dm.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dm.languages.models.Language;
import com.dm.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	@Autowired 
	private LanguageRepository languageRepository;

	 // returns all the expenses
	 public List<Language> allLanguages() {
	     return languageRepository.findAll();
	 }
	 
	 // creates an expense
	 public Language createLanguage(Language l) {
	     return languageRepository.save(l);
	 }
	 
	 // retrieves an expense
	 public Language findLanguage(Long id) {
	     Optional<Language> optionalLanguage = languageRepository.findById(id);
	     if(optionalLanguage.isPresent()) {
	         return optionalLanguage.get();
	     } else {
	         return null;
	     }
	 }
	 
	 //updates the expense 
	 public Language updateLanguage(Language l) {
	     return languageRepository.save(l);
	 }
	 
	 //Get Expense Details 
	public Language languageDetails(Long id) {
		return languageRepository.findById(id).orElse(null);
	}
	
	//must pass in ID to delete art by id 
	public void deleteLanguage(Long id) {
		languageRepository.deleteById(id);
	}
	

}
