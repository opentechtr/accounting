package com.otcp.Accounting.invoice.repository;

import com.otcp.Accounting.invoice.entity.InvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceItemRepository extends JpaRepository<InvoiceItem, Long> {
}