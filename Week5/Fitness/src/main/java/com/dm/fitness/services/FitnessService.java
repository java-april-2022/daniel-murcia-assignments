package com.dm.fitness.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dm.fitness.models.FitnessClass;
import com.dm.fitness.models.Trainer;
import com.dm.fitness.repositories.FitnessClassRepository;
import com.dm.fitness.repositories.TrainerRepository;

@Service 
public class FitnessService {
	@Autowired
	private FitnessClassRepository fitnessRepo;
	
	@Autowired
	private TrainerRepository trainerRepo;
	
	//All Trainers
	public List<Trainer> getAllTrainers(){
		return trainerRepo.findAll();
	}
	//Create Trainer
	public Trainer createTrainer(Trainer trainer) {
		return trainerRepo.save(trainer);
	}
	//All fitness classes: 
	public List<FitnessClass> getAllClasses(){
		return fitnessRepo.findAll();
	}
	//Create Fitness class:
	public FitnessClass createClass(FitnessClass fitnessClass) {
		return fitnessRepo.save(fitnessClass);
	}
}
