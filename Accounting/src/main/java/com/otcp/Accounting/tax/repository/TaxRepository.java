
package com.otcp.Accounting.tax.repository;

import com.otcp.Accounting.tax.entity.Tax;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TaxRepository extends JpaRepository<Tax, String> {}
