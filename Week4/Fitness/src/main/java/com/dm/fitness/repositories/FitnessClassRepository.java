package com.dm.fitness.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dm.fitness.models.FitnessClass;

@Repository
public interface FitnessClassRepository extends CrudRepository<FitnessClass, Long>{

	List<FitnessClass> findAll(); 
}
