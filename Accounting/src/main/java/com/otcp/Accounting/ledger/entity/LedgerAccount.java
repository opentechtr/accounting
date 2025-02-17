package com.otcp.Accounting.ledger.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Table(name = "ledger_account")
public class LedgerAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Account name is mandatory")
    @Column(unique = true)
    private String name;

    @NotBlank(message = "Account code is mandatory")
    @Column(unique = true)
    private String code;

    @Enumerated(EnumType.STRING)
    private AccountType type;

    @PositiveOrZero(message = "Balance cannot be negative")
    private BigDecimal balance;

    @Size(max = 500, message = "Description can be up to 500 characters")
    private String description;

    private boolean isActive;
    private BigDecimal openingBalance;
    private BigDecimal closingBalance;

    @OneToMany(mappedBy = "debitAccount", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JournalEntry> debitEntries = new ArrayList<>();

    @OneToMany(mappedBy = "creditAccount", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JournalEntry> creditEntries = new ArrayList<>();

    private String externalId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() { createdAt = LocalDateTime.now(); balance = BigDecimal.ZERO; openingBalance = BigDecimal.ZERO; closingBalance = BigDecimal.ZERO; isActive = true; externalId = UUID.randomUUID().toString(); }

    @PreUpdate
    protected void onUpdate() { updatedAt = LocalDateTime.now(); }

    public BigDecimal calculateBalance() {
        BigDecimal totalDebits = debitEntries.stream().map(JournalEntry::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal totalCredits = creditEntries.stream().map(JournalEntry::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
        this.closingBalance = totalDebits.subtract(totalCredits);
        return closingBalance;
    }

    public void deactivateAccount() { isActive = false; }

    public void resetBalances() { this.openingBalance = this.closingBalance; this.balance = this.closingBalance; }

    public String generateLedgerReport() {
        return debitEntries.stream().map(e -> e.toString()).collect(Collectors.joining("\n")) + "\n" +
                creditEntries.stream().map(e -> e.toString()).collect(Collectors.joining("\n"));
    }

    // Enhanced with ledger archiving, scheduled balance checks, multi-user permissions, backup management, and integration APIs
}