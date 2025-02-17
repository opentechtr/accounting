package com.otcp.Accounting.product.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @PositiveOrZero(message = "Quantity cannot be negative")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "warehouse_id", nullable = false)
    private Warehouse warehouse;

    private LocalDateTime lastUpdated;

    @PrePersist
    protected void onCreate() { lastUpdated = LocalDateTime.now(); }

    @PreUpdate
    protected void onUpdate() { lastUpdated = LocalDateTime.now(); }

    // Getters and setters
}
