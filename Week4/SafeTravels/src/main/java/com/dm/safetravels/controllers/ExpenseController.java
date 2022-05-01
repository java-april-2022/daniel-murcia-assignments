package com.dm.safetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.dm.safetravels.models.Expense;
import com.dm.safetravels.services.ExpenseService;
import com.example.week4.models.Art;


@Controller
public class ExpenseController {
	
	@Autowired 
	private ExpenseService expenseService;
	
	@GetMapping("/")
	public String index( @ModelAttribute("expense") Expense expenseModel, Model model) {
		List<Expense> expenses = expenseService.allExpenses();
		model.addAttribute("expenses", expenses);
		return "index.jsp";
	}

	@PostMapping("/create")
	public String create(@Valid @ModelAttribute("expense") Expense expenseModel, BindingResult result, Model model) {
//		List<Expense> expenses = expenseService.allExpenses();
//		model.addAttribute("expenses", expenses);
		
		if(result.hasErrors()) {
			List<Expense> expenses = expenseService.allExpenses();
			model.addAttribute("expenses", expenses);
			return "index.jsp";
		}
		expenseService.createExpense(expenseModel);
		return "redirect:/";
	}
	
	//Update Art (get/put)
	@GetMapping ("/edit/{id}")
	public String editExpense(@PathVariable Long id, Model model) {
		Expense editExpense=expenseService.expenseDetails(id);
		model.addAttribute("editExpense", editExpense);
		return "edit.jsp";
	}
	
	//UPDATE METHOD IS STILL MISSING VALIDATIONS: 
	@PutMapping("/update/{id}")
	public String updateExpense(@Valid @ModelAttribute("editExpense") Expense editedExpense, BindingResult result, @PathVariable Long id) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		
		expenseService.updateExpense(editedExpense);
		return "redirect:/";
	}
	
	//Delete Expense: 
	@DeleteMapping("/delete/{id}")
	public String deleteExpense(@PathVariable Long id) {
		expenseService.deleteExpense(id);
		return "redirect:/";
	}

	//Show Expense Details: 
	@GetMapping("expenseDetails/{id}")
	public String expenseDetails(@PathVariable Long id, Model model) {
		Expense expense = expenseService.expenseDetails(id);
		model.addAttribute("expense", expense);
		return "details.jsp";
	}
	
	//ONLY MISSING "GO BACK" BUTTON TO RETURN TO INDEX FROM SHOW DETAILS PAGE. 

}
