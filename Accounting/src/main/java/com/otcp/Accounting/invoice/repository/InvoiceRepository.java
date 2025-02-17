package com.otcp.Accounting.invoice.repository;

import com.otcp.Accounting.invoice.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}