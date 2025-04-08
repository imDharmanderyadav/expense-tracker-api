package com.expensetracker.expense_tracker_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.expensetracker.expense_tracker_api.model.Category;
import com.expensetracker.expense_tracker_api.model.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense ,Long> {
    List<Expense> findByCategory(Category category);

    @Query("SELECT e.category, SUM(e.amount) FROM Expense e GROUP BY e.category")
    List<Object[]> getCategorySummary();
}
