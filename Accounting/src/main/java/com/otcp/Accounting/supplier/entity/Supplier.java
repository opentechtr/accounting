package com.otcp.Accounting.supplier.entity;

import com.otcp.Accounting.common.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.List;

@Entity
@Table(name = "supplier")
public class Supplier extends BaseEntity {
    @NotBlank(message = "Supplier name is mandatory")
    @Column(unique = true)
    private String name;

    @Email(message = "Email should be valid")
    private String email;

    @Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "Phone number is invalid")
    private String phone;

    @NotBlank(message = "Address is mandatory")
    private String address;

    @NotBlank(message = "Tax number is mandatory")
    @Column(unique = true)
    private String taxNumber;

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SupplierInvoice> invoices;

    // Detailed Getters and setters with validation logic
}
