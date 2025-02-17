
package com.otcp.Accounting.supplier.service.impl;

import com.otcp.Accounting.supplier.entity.Supplier;
import com.otcp.Accounting.supplier.service.SupplierService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {


    @Override
    public Supplier saveSupplier(Supplier supplier) {
        return null;
    }

    @Override
    public Supplier getSupplierById(Long id) {
        return null;
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return null;
    }

    @Override
    public Supplier updateSupplier(Long id, Supplier supplier) {
        return null;
    }

    @Override
    public void deleteSupplier(Long id) {

    }

    @Override
    public List<Supplier> searchSupplierByName(String name) {
        return null;
    }
}
