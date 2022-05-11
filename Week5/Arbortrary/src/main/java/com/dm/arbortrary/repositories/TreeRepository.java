package com.dm.arbortrary.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dm.arbortrary.models.Tree;

@Repository
public interface TreeRepository extends CrudRepository<Tree, Long> {
	
	List<Tree> findAll();

}
