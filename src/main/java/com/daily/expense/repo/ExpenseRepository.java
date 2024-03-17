package com.daily.expense.repo;

import com.daily.expense.model.ExpenseModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<ExpenseModel,Long> {
    public List<ExpenseModel> findByExpenseType(String expenseType);
}
