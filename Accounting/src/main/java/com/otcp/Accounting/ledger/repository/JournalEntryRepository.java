package com.otcp.Accounting.ledger.repository;

import com.otcp.Accounting.ledger.entity.JournalEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalEntryRepository extends JpaRepository<JournalEntry, Long> {
}