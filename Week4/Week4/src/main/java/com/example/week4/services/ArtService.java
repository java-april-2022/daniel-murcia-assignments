package com.example.week4.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.week4.models.Art;
import com.example.week4.repositories.ArtRepository;

@Service
public class ArtService {
	
	@Autowired //prevents you from having to make a constructor. 
	private ArtRepository artRepo;
	
	//constructor, not necessary because of autowired. 
//	public ArtService(ArtRepository artRepo) {
//		this.artRepo = artRepo;
//	}

	public List<Art> getAllArts(){
		//Business Logic 
		return artRepo.findAll();
	}

	//these methods will Call Repository and use CrudRepo methods. 
	//find all arts 
	//create art 
	//update art 
	//delete art 
	
}
