package com.dm.userprojects.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.dm.userprojects.models.LoginUser;
import com.dm.userprojects.models.Project;
import com.dm.userprojects.models.User;
import com.dm.userprojects.services.ProjectService;
import com.dm.userprojects.services.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ProjectService projectService;
	
	@GetMapping("/")
	public String index(
			//We need to provide BOTH model attributes in the root route. 
			@ModelAttribute("newUser") User user, 
			@ModelAttribute("newLogin") LoginUser loginUser) {
		return "index.jsp";
	}
	
	
	//*********Register a User************
	@PostMapping("/registration")
	public String registerUser(@Valid @ModelAttribute("newUser") User user,
			BindingResult result, HttpSession session, @ModelAttribute("newLogin") LoginUser loginUser) {
		//validate user
		userService.validate(user, result);
		if(result.hasErrors()) {
			return "index.jsp";
		}
		//register user
		userService.registerUser(user);
		
		//put user in session
		session.setAttribute("loggedInUser", user);
		return "redirect:/dashboard";
	}
	
	//*********Login***************
	@PostMapping("/login")
	public String loginUser(@Valid @ModelAttribute("newLogin") LoginUser loginUser, 
			BindingResult results, 
			HttpSession session, 
			@ModelAttribute("newUser") User user) {
		
		// authenticate user
		userService.authenticateUser(loginUser, results);
		if (results.hasErrors()) {
			return "index.jsp";
		}
		User loggedInUser=userService.findByEmail(loginUser.getEmail());
		
		
		// put user in session 
		session.setAttribute("loggedInUser", loggedInUser);
		
		return "redirect:/dashboard";
	}
	
	//********Logout**********
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model projectModel) {
		//check if user is in session; 
		if(session.getAttribute("loggedInUser")!=null){
			projectModel.addAttribute("projects", projectService.allProjects());
			return "dashboard.jsp";
		} 
		else {
			return "redirect:/";
		}
	}
	
	//New Project
	@GetMapping("/new")
	public String newProject(HttpSession session, @ModelAttribute("newProject") Project project) {
		if (session.getAttribute("loggedInUser")!=null) {
			return "new.jsp";
		}
		else {
			return "redirect:/";
		}
	}
	
	//CREATE PROJECT
	@PostMapping("/projects/create")
	public String CreateProject(@Valid @ModelAttribute ("newProject") Project project, BindingResult results) {
		if (results.hasErrors()) {
			return "new.jsp";
		}
		else {
			projectService.createProject(project);
			return "redirect:/dashboard";
		}
	}
	
	//SHOW PROJECT DETAILS:
	@GetMapping("/projects/projectDetails/{id}")
	public String projectDetails(@PathVariable Long id,  Model projectModel, HttpSession session) {
		if (session.getAttribute("loggedInUser")!=null) {
			Project project = projectService.getOneProject(id);
			projectModel.addAttribute("project", project);
			return "projectDetails.jsp";
		}
		else {
			return "redirect:/";
		}		
	}
	
	// DELETE A PROJECT
	@GetMapping("/delete/{id}")
	public String deleteProject(@PathVariable Long id) {
		projectService.deleteProject(id);
		return "redirect:/dashboard";
	}
	
	//Alternatively, use delete mapping with a put request:
//	@DeleteMapping
	
	//Edit 
	@GetMapping("/edit/{id}")
	public String editProject(@PathVariable Long id, Model model) {
		Project editProject=projectService.getOneProject(id);
		model.addAttribute("editProject", editProject);
		return "edit.jsp";
	}
	//UPDATE: 
	@PutMapping("/update/{id}")
	public String updateProject(@Valid @ModelAttribute("editProject") Project editedProject, BindingResult result, @PathVariable Long id) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		projectService.updateProject(editedProject);
		return "redirect:/dashboard";
	}
}
