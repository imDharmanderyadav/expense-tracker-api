package com.expensetracker.expense_tracker_api.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.expensetracker.expense_tracker_api.model.Category;
import com.expensetracker.expense_tracker_api.model.Expense;

public interface ExpenseService {
    Expense creatExpense(Expense expense);

    List<Expense> getAllExpenses();

    Expense getExpenseById(Long id);

    Expense updateExpense(Long id, Expense expense);

    void deleteExpense(Long id);

    List<Expense> getExpensesByCategory(Category category);

    Map<String, BigDecimal > getSummary();

}
