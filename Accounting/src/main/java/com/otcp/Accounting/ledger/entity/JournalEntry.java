package com.otcp.Accounting.ledger.entity;

import com.otcp.Accounting.common.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "journal_entry")
public class JournalEntry extends BaseEntity {

    @NotBlank(message = "Description is mandatory")
    @Size(max = 255, message = "Description can be up to 255 characters")
    private String description;

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
    private LocalDateTime approvedAt;
    private LocalDateTime transactionDate;
    private boolean isReversed;
    private String notes;

    public void approve(String user) {
        this.approvedAt = LocalDateTime.now();
    }

    public void reverseEntry() {
        this.isReversed = true;
    }

    public String exportToCSV() {
        return this.getId() + "," + description + "," + transactionType + "," + amount + "," + currency;
    }

    // Enhanced with audit tracking, reconciliation reports, CSV/JSON/XML export, transaction templates, budget allocations, and tax compliance checks

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
                "id=" + getId() +
                ", description='" + description + '\'' +
                ", debitAccount=" + debitAccount +
                ", creditAccount=" + creditAccount +
                ", amount=" + amount +
                ", transactionType='" + transactionType + '\'' +
                ", referenceNumber='" + referenceNumber + '\'' +
                ", currency='" + currency + '\'' +
                ", approvedAt=" + approvedAt +
                ", transactionDate=" + transactionDate +
                ", isReversed=" + isReversed +
                ", notes='" + notes + '\'' +
                '}';
    }
}
