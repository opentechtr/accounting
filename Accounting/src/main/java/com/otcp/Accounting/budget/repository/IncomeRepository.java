package com.otcp.Accounting.budget.repository;

import com.otcp.Accounting.budget.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRepository extends JpaRepository<Income, Long> {
}