package com.dm.safetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dm.safetravels.models.Expense;
import com.dm.safetravels.repositories.ExpenseRepository;


@Service
public class ExpenseService {

	@Autowired //prevents you from having to make a constructor. 
	private ExpenseRepository expenseRepository;
	

	 // returns all the expenses
	 public List<Expense> allExpenses() {
	     return expenseRepository.findAll();
	 }
	 
	 // creates an expense
	 public Expense createExpense(Expense e) {
	     return expenseRepository.save(e);
	 }
	 
	 // retrieves an expense
	 public Expense findExpense(Long id) {
	     Optional<Expense> optionalExpense = expenseRepository.findById(id);
	     if(optionalExpense.isPresent()) {
	         return optionalExpense.get();
	     } else {
	         return null;
	     }
	 }
	 
	 //updates the expense 
	 public Expense updateExpense(Expense e) {
	     return expenseRepository.save(e);
	 }
	 
	 //Get Expense Details 
	public Expense expenseDetails(Long id) {
		return expenseRepository.findById(id).orElse(null);
	}
	
	//must pass in ID to delete art by id 
	public void deleteExpense(Long id) {
		expenseRepository.deleteById(id);
	}
	

	 
}
