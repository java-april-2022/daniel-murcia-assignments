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
	
	public void createArt(Art art) {
		artRepo.save(art);
	}
	//update art 
	
	public void updateArt(Art art) {
		artRepo.save(art);
	}
	//delete art 
	
	//must pass in ID to delete art by id 
	public void deleteArt(Long id) {
		artRepo.deleteById(id);
	}
	
	//Get Art Details 
	public Art artDetails(Long id) {
		return artRepo.findById(id).orElse(null);
	}
	
}
