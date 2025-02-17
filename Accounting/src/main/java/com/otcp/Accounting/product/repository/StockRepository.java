package com.otcp.Accounting.product.repository;

import com.otcp.Accounting.product.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}