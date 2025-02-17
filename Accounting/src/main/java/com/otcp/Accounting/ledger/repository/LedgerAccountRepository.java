package com.otcp.Accounting.ledger.repository;

import com.otcp.Accounting.ledger.entity.JournalEntry;
import com.otcp.Accounting.ledger.entity.LedgerAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LedgerAccountRepository extends JpaRepository<LedgerAccount, Long> {
    LedgerAccount createAccount(LedgerAccount account);
    LedgerAccount getAccountById(Long id);
    List<LedgerAccount> getAllAccounts();
    LedgerAccount updateAccount(Long id, LedgerAccount account);
    void deleteAccount(Long id);
    void archiveLedger(Long id);

    JournalEntry createJournalEntry(JournalEntry entry);
    JournalEntry getJournalEntryById(Long id);
    List<JournalEntry> getAllJournalEntries();
    JournalEntry updateJournalEntry(Long id, JournalEntry entry);
    void deleteJournalEntry(Long id);
}