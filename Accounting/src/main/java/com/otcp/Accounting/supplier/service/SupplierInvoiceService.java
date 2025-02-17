package com.otcp.Accounting.supplier.service;

import com.otcp.Accounting.supplier.entity.SupplierInvoice;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SupplierInvoiceService {
    SupplierInvoice saveInvoice(SupplierInvoice invoice);
    SupplierInvoice getInvoiceById(Long id);
    List<SupplierInvoice> getAllInvoices();
    SupplierInvoice updateInvoice(Long id, SupplierInvoice invoice);
    void deleteInvoice(Long id);
    List<SupplierInvoice> searchInvoiceByNumber(String number);
}
