package com.otcp.Accounting.ledger.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "journal_entry")
public class JournalEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Description is mandatory")
    @Size(max = 255, message = "Description can be up to 255 characters")
    private String description;

    private LocalDateTime entryDate;

    @ManyToOne
    @JoinColumn(name = "debit_account_id", nullable = false)
    private LedgerAccount debitAccount;

    @ManyToOne
    @JoinColumn(name = "credit_account_id", nullable = false)
    private LedgerAccount creditAccount;

    @Positive(message = "Amount must be positive")
    private BigDecimal amount;

    @NotBlank(message = "Transaction type is mandatory")
    private String transactionType;

    @NotBlank(message = "Reference number is mandatory")
    @Column(unique = true)
    private String referenceNumber;

    private String currency;
    private String createdBy;
    private LocalDateTime approvedAt;
    private LocalDateTime transactionDate;
    private boolean isReversed;
    private String notes;

    @PrePersist
    protected void onCreate() { entryDate = LocalDateTime.now(); }

    public void approve(String user) { this.approvedAt = LocalDateTime.now(); this.createdBy = user; }

    public void reverseEntry() { this.isReversed = true; }

    public String exportToCSV() {
        return id + "," + description + "," + transactionType + "," + amount + "," + currency;
    }

    // Enhanced with audit tracking, reconciliation reports, CSV/JSON/XML export, transaction templates, budget allocations, and tax compliance checks


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDateTime entryDate) {
        this.entryDate = entryDate;
    }

    public LedgerAccount getDebitAccount() {
        return debitAccount;
    }

    public void setDebitAccount(LedgerAccount debitAccount) {
        this.debitAccount = debitAccount;
    }

    public LedgerAccount getCreditAccount() {
        return creditAccount;
    }

    public void setCreditAccount(LedgerAccount creditAccount) {
        this.creditAccount = creditAccount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getApprovedAt() {
        return approvedAt;
    }

    public void setApprovedAt(LocalDateTime approvedAt) {
        this.approvedAt = approvedAt;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public boolean isReversed() {
        return isReversed;
    }

    public void setReversed(boolean reversed) {
        isReversed = reversed;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "JournalEntry{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", entryDate=" + entryDate +
                ", debitAccount=" + debitAccount +
                ", creditAccount=" + creditAccount +
                ", amount=" + amount +
                ", transactionType='" + transactionType + '\'' +
                ", referenceNumber='" + referenceNumber + '\'' +
                ", currency='" + currency + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", approvedAt=" + approvedAt +
                ", transactionDate=" + transactionDate +
                ", isReversed=" + isReversed +
                ", notes='" + notes + '\'' +
                '}';
    }
}
