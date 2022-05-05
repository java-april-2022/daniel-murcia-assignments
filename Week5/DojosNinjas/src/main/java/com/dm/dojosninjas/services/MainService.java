package com.dm.dojosninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dm.dojosninjas.models.Dojo;
import com.dm.dojosninjas.models.Ninja;
import com.dm.dojosninjas.repositories.DojoRepository;
import com.dm.dojosninjas.repositories.NinjaRepository;
import com.dm.safetravels.models.Expense;

@Service
public class MainService {
	@Autowired
	private DojoRepository dojoRepo;
	
	@Autowired
	private NinjaRepository ninjaRepo;
	
	//All Dojos
	public List<Dojo> getAllDojos(){
		return dojoRepo.findAll();
	}
	//Create Dojo
	public Dojo createDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	//All Ninjas : 
	public List<Ninja> getAllNinjas(){
		return ninjaRepo.findAll();
	}
	//Create Ninjas:
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
	//All Ninjas from One Dojo 
	public List<Ninja> getAllByDojoId(Long dojoId){
		return ninjaRepo.findByDojoId(dojoId);
	}
	
	public Dojo dojoDetails(Long id) {
		return dojoRepo.findById(id).orElse(null);
	}
}
