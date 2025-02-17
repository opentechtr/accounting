package com.otcp.Accounting.product.repository;

import com.otcp.Accounting.product.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
}