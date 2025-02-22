package com.otcp.Accounting.budget.entity;

import com.otcp.Accounting.common.baseEntity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Income extends BaseEntity {

    private String source;
    private BigDecimal amount;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "budget_id")
    private Budget budget;
    // Getters and Setters
}
