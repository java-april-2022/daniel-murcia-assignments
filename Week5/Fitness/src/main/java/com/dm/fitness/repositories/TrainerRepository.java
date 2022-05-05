package com.dm.fitness.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dm.fitness.models.Trainer;

@Repository
public interface TrainerRepository extends CrudRepository<Trainer, Long>{

	List<Trainer> findAll();
}
