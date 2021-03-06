package com.dm.userprojects.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dm.userprojects.models.Project;
import com.dm.userprojects.models.User;
import com.dm.userprojects.repositories.ProjectRepository;

@Service
public class ProjectService {
	
	
	@Autowired
	private ProjectRepository projectRepo; 
	
	//List all projects
	public List<Project> allProjects(){
		return projectRepo.findAll();
	}
	
	//Create new Project 
	public Project createProject(Project project) {
		return projectRepo.save(project);
	}
	
	//Delete a Project
	public void deleteProject(Long id) {
		projectRepo.deleteById(id);
	}
	
	// Get One Project Details
	public Project getOneProject(Long id) {
		return projectRepo.findById(id).orElse(null);
	}
	
	//Update project
	public Project updateProject(Project project) {
		return projectRepo.save(project);
	}
	
	//Like
	public void likeProject(Project project, User user) {
		List<User> likers = project.getLikers();
		likers.add(user);
		projectRepo.save(project);
	}
	
	//Unlike 
	public void unlikeProject(Project project, User user) {
		List<User> likers = project.getLikers();
		likers.remove(user);
		projectRepo.save(project);
	}
}
