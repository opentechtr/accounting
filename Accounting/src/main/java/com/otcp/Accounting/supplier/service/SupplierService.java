
package com.otcp.Accounting.supplier.service;

import com.otcp.Accounting.supplier.entity.Supplier;

import java.util.List;

public interface SupplierService {
    Supplier saveSupplier(Supplier supplier);
    Supplier getSupplierById(Long id);
    List<Supplier> getAllSuppliers();
    Supplier updateSupplier(Long id, Supplier supplier);
    void deleteSupplier(Long id);
    List<Supplier> searchSupplierByName(String name);

}
