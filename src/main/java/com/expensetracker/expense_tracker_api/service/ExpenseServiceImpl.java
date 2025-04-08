package com.expensetracker.expense_tracker_api.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expensetracker.expense_tracker_api.exception.ResourceNotFoundException;
import com.expensetracker.expense_tracker_api.model.Category;
import com.expensetracker.expense_tracker_api.model.Expense;
import com.expensetracker.expense_tracker_api.repository.ExpenseRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;

    @Autowired
    public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public Expense creatExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    @Override
    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);

    }

    @Override
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    @Override
    public Expense getExpenseById(Long id) {
        return expenseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Expense Not Found with Id "+ id));
    }

    @Override
    public Expense updateExpense(Long id, Expense updatedExpense) {
        return expenseRepository.findById(id).map(existingExpense -> {
            existingExpense.setTitle(updatedExpense.getTitle());
            existingExpense.setAmount(updatedExpense.getAmount());
            existingExpense.setCategory(updatedExpense.getCategory());
            existingExpense.setDate(updatedExpense.getDate());
            return expenseRepository.save(existingExpense);
        }).orElse(null);
    }

    @Override
    public List<Expense> getExpensesByCategory(Category category) {
        return expenseRepository.findByCategory(category);
    }

    @Override
    public Map<String, BigDecimal> getSummary(){
        List<Object[]> summaryList = expenseRepository.getCategorySummary();
        Map<String, BigDecimal> summaryMap = new HashMap<>();

        for (Object[] row : summaryList) {
            String category = row[0].toString();
            BigDecimal totalAmount = (BigDecimal) row[1];
            summaryMap.put(category, totalAmount);
        }
        
        return summaryMap;
    }

}
