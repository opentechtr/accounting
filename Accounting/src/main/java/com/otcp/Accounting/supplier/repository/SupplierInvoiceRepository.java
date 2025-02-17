package com.otcp.Accounting.supplier.repository;

import com.otcp.Accounting.supplier.entity.SupplierInvoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierInvoiceRepository extends JpaRepository<SupplierInvoice, Long> {
}