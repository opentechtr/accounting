package com.otcp.Accounting.product.entity;

import com.otcp.Accounting.common.baseEntity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "warehouse")
public class Warehouse extends BaseEntity {
    @NotBlank(message = "Warehouse name is mandatory")
    @Column(unique = true)
    private String name;

    @NotBlank(message = "Location is mandatory")
    private String location;

    @OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Stock> stocks = new ArrayList<>();

    // Getters and setters
}
