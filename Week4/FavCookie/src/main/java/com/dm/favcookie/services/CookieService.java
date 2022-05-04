package com.dm.favcookie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dm.favcookie.models.Cookie;
import com.dm.favcookie.repositories.CookieRepository;

@Service 
public class CookieService {
	@Autowired
	private CookieRepository repository;
	
	
	//All Trainers
	public List<Cookie> all(){
		return repository.findAll();
	}
	//Create Trainer
	public Cookie create(Cookie item) {
		return repository.save(item);
	}

	//Create Fitness class:
	public Cookie createClass(Cookie item) {
		return repository.save(item);
	}
	
	public Cookie retrieve(Long id) {
		return this.repository.findById(id).get();
	}
	
	public Cookie save(Cookie item) {
		return this.repository.save(item);
	}
}
