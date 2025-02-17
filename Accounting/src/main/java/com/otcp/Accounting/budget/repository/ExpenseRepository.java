package com.otcp.Accounting.budget.repository;

import com.otcp.Accounting.budget.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}