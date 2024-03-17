package com.daily.expense.controller;

import com.daily.expense.model.ExpenseModel;
import com.daily.expense.repo.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/expense")
@CrossOrigin("*")
public class ExpenseController {

    @Autowired
    ExpenseRepository expenseRepository;

    @PostMapping("/addExpense")
    public void addExpense(@RequestBody ExpenseModel exp) {
        exp.setCreatedDate(new Date());
        expenseRepository.save(exp);
    }

    @PostMapping("/getExpense")
    public List<ExpenseModel> getExpense(@RequestBody ExpenseModel exp) {
       return expenseRepository.findByExpenseType(exp.getExpenseType());
    }
}
