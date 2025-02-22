package com.otcp.Accounting.customer.entity;


import com.otcp.Accounting.common.baseEntity.BaseEntity;
import com.otcp.Accounting.invoice.entity.Invoice;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Customer extends BaseEntity {

    @NotBlank(message = "First name is mandatory")
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    private String lastName;

    @Email(message = "Email should be valid")
    private String email;

    @Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "Phone number is invalid")
    private String phone;

    @NotBlank(message = "Tax number is mandatory")
    @Column(unique = true)
    private String taxNumber;

    private String companyName;
    private Date dateOfBirth;
    private String notes;

    @Enumerated(EnumType.STRING)
    private CustomerStatus status;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses = new ArrayList<>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Invoice> invoices = new ArrayList<>();

    // Constructors, getters and setters

    public Customer() {
    }

    public Customer(String firstName, String lastName, String email, String phone, String taxNumber, String companyName, Date dateOfBirth, String notes, CustomerStatus status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.taxNumber = taxNumber;
        this.companyName = companyName;
        this.dateOfBirth = dateOfBirth;
        this.notes = notes;
        this.status = status;
    }
}
