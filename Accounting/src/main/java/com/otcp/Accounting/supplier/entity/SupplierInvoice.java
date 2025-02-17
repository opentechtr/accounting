package com.otcp.Accounting.supplier.entity;



import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name = "supplier_invoice")
public class SupplierInvoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Invoice number is mandatory")
    @Column(unique = true)
    private String invoiceNumber;

    @NotNull(message = "Issue date is mandatory")
    private LocalDateTime issueDate;

    @Positive(message = "Amount must be positive")
    private BigDecimal amount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() { createdAt = LocalDateTime.now(); }

    @PreUpdate
    protected void onUpdate() { updatedAt = LocalDateTime.now(); }

    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = false)
    private Supplier supplier;

    // Detailed Getters and setters
}
