package com.otcp.Accounting.budget.entity;

import com.otcp.Accounting.common.baseEntity.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Budget extends BaseEntity {
    private String name;
    private BigDecimal totalAmount;
    private BigDecimal allocatedAmount;
    private BigDecimal remainingAmount;
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;

    @OneToMany(mappedBy = "budget", cascade = CascadeType.ALL)
    private List<Expense> expenses;

    @OneToMany(mappedBy = "budget", cascade = CascadeType.ALL)
    private List<Income> incomes;

    // Getters and Setters
}
