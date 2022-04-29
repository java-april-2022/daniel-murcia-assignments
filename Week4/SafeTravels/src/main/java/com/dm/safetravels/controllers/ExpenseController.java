package com.dm.safetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dm.safetravels.models.Expense;
import com.dm.safetravels.services.ExpenseService;

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
}
