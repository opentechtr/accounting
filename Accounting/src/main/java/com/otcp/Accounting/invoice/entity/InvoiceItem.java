package com.otcp.Accounting.invoice.entity;

import com.otcp.Accounting.common.BaseEntity;
import com.otcp.Accounting.product.entity.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

@Entity
public class InvoiceItem extends BaseEntity {
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
