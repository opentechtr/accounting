package com.otcp.Accounting.tax.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tax")
public class Tax {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Tax name is mandatory")
    @Column(unique = true)
    private String name;

    @Positive(message = "Rate must be positive")
    private BigDecimal rate;

    @Size(max = 500, message = "Description can be up to 500 characters")
    private String description;

    private boolean isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() { createdAt = LocalDateTime.now(); isActive = true; }

    @PreUpdate
    protected void onUpdate() { updatedAt = LocalDateTime.now(); }

    // Detailed Getters and setters including isActive toggle
}
