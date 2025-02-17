package com.otcp.Accounting.supplier.repository;

import com.otcp.Accounting.supplier.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}