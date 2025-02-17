package com.otcp.Accounting.product.repository;

import com.otcp.Accounting.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}