package com.otcp.Accounting.supplier.service.impl;

import com.otcp.Accounting.supplier.entity.SupplierInvoice;
import com.otcp.Accounting.supplier.service.SupplierInvoiceService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SupplierInvoiceServiceImpl implements SupplierInvoiceService {
    @Override
    public SupplierInvoice saveInvoice(SupplierInvoice invoice) {
        return null;
    }

    @Override
    public SupplierInvoice getInvoiceById(Long id) {
        return null;
    }

    @Override
    public List<SupplierInvoice> getAllInvoices() {
        return null;
    }

    @Override
    public SupplierInvoice updateInvoice(Long id, SupplierInvoice invoice) {
        return null;
    }

    @Override
    public void deleteInvoice(Long id) {

    }

    @Override
    public List<SupplierInvoice> searchInvoiceByNumber(String number) {
        return null;
    }
}
