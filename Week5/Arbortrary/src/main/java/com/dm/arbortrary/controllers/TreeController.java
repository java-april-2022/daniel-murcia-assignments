package com.dm.arbortrary.controllers;

import java.util.List;

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

import com.dm.arbortrary.models.Tree;
import com.dm.arbortrary.models.User;
import com.dm.arbortrary.services.TreeService;
import com.dm.arbortrary.services.UserService;

@Controller
public class TreeController {

	@Autowired
	private TreeService treeService;
	
	@Autowired
	private UserService userService;
	
	
	//NEW BOOK
	@GetMapping("/new")
	public String newTree(
			@ModelAttribute ("newTree") Tree tree, 
			Model model) {
		return "new.jsp";
	}
	
	//CREATE 
	@PostMapping("/create")
	public String createTree(@Valid 
			@ModelAttribute ("newTree") Tree tree, BindingResult results) {
	if (results.hasErrors()) {
		return "new.jsp";
	}
	else {
		treeService.createTree(tree);
		return "redirect:/dashboard";
		}
	}
	
	//SHOW DETAILS -- need to pass in list of Visitors 
	@GetMapping("/trees/treeDetails/{id}")
	public String showTreeDetails(@PathVariable Long id, Model treeModel, HttpSession session) {
		if (session.getAttribute("loggedInUser")!=null) {
			//Creating a tree object with the tree details stored inside. 
			Tree tree = treeService.getOneTree(id);
			List<User> visitors = treeService.allVisitors(tree);
			// Using the treeModel to render the tree object + details onto the JSP page. 
			User user = (User)session.getAttribute("loggedInUser");
			User userLoggedIn=userService.findById(user.getId());
			treeModel.addAttribute("userLoggedIn", userLoggedIn);
			treeModel.addAttribute("tree", tree);
			treeModel.addAttribute("visitors", visitors);
			return "details.jsp";
		}
		else {
			return "redirect:/";
		}
	}

	// DELETE
	@GetMapping("/delete/{id}")
	public String deleteTree(@PathVariable Long id) {
		treeService.deleteTree(id);
		return "redirect:/dashboard";
	}
	
	//Edit 
	@GetMapping("/edit/{id}")
	public String editTree(@PathVariable Long id, Model model) {
		Tree editTree=treeService.getOneTree(id);
		model.addAttribute("editTree", editTree);
		return "edit.jsp";
	}
	//UPDATE: 
	@PutMapping("/update/{id}")
	public String updateTree(@Valid @ModelAttribute("editTree") Tree editedTree, BindingResult result, @PathVariable Long id) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		treeService.updateTree(editedTree);
		return "redirect:/dashboard";
	}	
	
	//Visit Tree
	@GetMapping("/tree/{id}/visit")
	public String visitTree(@PathVariable Long id, HttpSession session) {
		Tree tree = treeService.getOneTree(id);
		User user = (User) session.getAttribute("loggedInUser");
		
		User userWhoIsVisiting=userService.findById(user.getId());
		
		treeService.visitTree(tree, userWhoIsVisiting);
		return "redirect:/dashboard";
	} 
	
	//Unvisit Tree
	@GetMapping("/tree/{id}/unvisit")
	public String unvisitTree(@PathVariable Long id, HttpSession session) {
		Tree tree = treeService.getOneTree(id);
		User user = (User) session.getAttribute("loggedInUser");
		
		
		User userWhoIsUnvisiting=userService.findById(user.getId());
		
		treeService.unvisitTree(tree, userWhoIsUnvisiting);
		return "redirect:/dashboard";
	} 
	

	
}
