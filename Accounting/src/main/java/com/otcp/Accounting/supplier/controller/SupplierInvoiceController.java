package com.otcp.Accounting.supplier.controller;

import com.otcp.Accounting.supplier.entity.SupplierInvoice;
import com.otcp.Accounting.supplier.service.SupplierInvoiceService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supplier-invoices")
public class SupplierInvoiceController {
    private final SupplierInvoiceService invoiceService;

    public SupplierInvoiceController(SupplierInvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping
    public ResponseEntity<SupplierInvoice> createInvoice(@Valid @RequestBody SupplierInvoice invoice) {
        return new ResponseEntity<>(invoiceService.saveInvoice(invoice), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierInvoice> getInvoiceById(@PathVariable Long id) {
        return ResponseEntity.ok(invoiceService.getInvoiceById(id));
    }

    @GetMapping
    public ResponseEntity<List<SupplierInvoice>> getAllInvoices() {
        return ResponseEntity.ok(invoiceService.getAllInvoices());
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupplierInvoice> updateInvoice(@PathVariable Long id, @Valid @RequestBody SupplierInvoice invoice) {
        return ResponseEntity.ok(invoiceService.updateInvoice(id, invoice));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvoice(@PathVariable Long id) {
        invoiceService.deleteInvoice(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<SupplierInvoice>> searchInvoiceByNumber(@RequestParam String number) {
        return ResponseEntity.ok(invoiceService.searchInvoiceByNumber(number));
    }
}
