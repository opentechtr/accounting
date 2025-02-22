package com.otcp.Accounting.supplier.entity;



import com.otcp.Accounting.common.baseEntity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name = "supplier_invoice")
public class SupplierInvoice extends BaseEntity {
    @NotBlank(message = "Invoice number is mandatory")
    @Column(unique = true)
    private String invoiceNumber;

    @NotNull(message = "Issue date is mandatory")
    private LocalDateTime issueDate;

    @Positive(message = "Amount must be positive")
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = false)
    private Supplier supplier;

    // Detailed Getters and setters
}
