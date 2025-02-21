package com.otcp.Accounting.product.entity;


import com.otcp.Accounting.common.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
public class Product extends BaseEntity {
    @NotBlank(message = "Product name is mandatory")
    private String name;

    @NotBlank(message = "Product code is mandatory")
    @Column(unique = true)
    private String code;

    @Size(max = 500, message = "Description can be up to 500 characters")
    private String description;

    @Positive(message = "Price must be positive")
    private BigDecimal price;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Stock> stocks = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    // Getters and setters with validations
}

