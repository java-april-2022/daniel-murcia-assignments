package com.dm.arbortrary.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dm.arbortrary.models.Tree;
import com.dm.arbortrary.models.User;
import com.dm.arbortrary.repositories.TreeRepository;

@Service
public class TreeService {
	
	
	@Autowired
	private TreeRepository treeRepo; 
	
	//List all trees
	public List<Tree> allTrees(){
		return treeRepo.findAll();
	}
	
	//Create new Tree 
	public Tree createTree(Tree tree) {
		return treeRepo.save(tree);
	}
	
	//Delete a Tree
	public void deleteTree(Long id) {
		treeRepo.deleteById(id);
	}
	
	// Get One Tree Details
	public Tree getOneTree(Long id) {
		return treeRepo.findById(id).orElse(null);
	}
	
	//Update tree
	public Tree updateTree(Tree tree) {
		return treeRepo.save(tree);
	}
	
	//Like
	public void visitTree(Tree tree, User user) {
		List<User> visitors = tree.getVisitors();
		visitors.add(user);
		treeRepo.save(tree);
	}
	
	//Unvisit 
	public void unvisitTree(Tree tree, User user) {
		List<User> visitors = tree.getVisitors();
		visitors.remove(user);
		treeRepo.save(tree);
	}
	
	//Get Visitors 
	public List<User> allVisitors(Tree tree){
		return tree.getVisitors();
	}
}
