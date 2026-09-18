package com.example.cooling.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.cooling.entity.Invoice;
import com.example.cooling.service.InvoiceService;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService service;

    @PostMapping("/generate/{customerId}")
    public Invoice generateInvoice(@PathVariable Long customerId) {
        return service.generateInvoice(customerId);
    }

    @GetMapping
    public List<Invoice> getAllInvoices() {
        return service.getAllInvoices();
    }
}