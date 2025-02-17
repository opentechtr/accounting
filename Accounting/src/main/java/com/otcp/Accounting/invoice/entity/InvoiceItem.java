package com.otcp.Accounting.invoice.entity;

import com.otcp.Accounting.product.entity.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class InvoiceItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "invoice_id", nullable = false)
    private Invoice invoice;

    @Positive(message = "Quantity must be positive")
    private int quantity;

    @Positive(message = "Unit price must be positive")
    private BigDecimal unitPrice;

    @PositiveOrZero(message = "Total must be zero or positive")
    private BigDecimal total;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() { createdAt = LocalDateTime.now(); }

    @PreUpdate
    protected void onUpdate() { updatedAt = LocalDateTime.now(); }

    public InvoiceItem() {}

    public InvoiceItem(Product product, Invoice invoice, int quantity, BigDecimal unitPrice) {
        this.product = product;
        this.invoice = invoice;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.total = unitPrice.multiply(BigDecimal.valueOf(quantity));
    }

    // Getters and Setters
}
