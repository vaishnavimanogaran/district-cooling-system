package com.example.cooling.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cooling.dto.ReportResponse;
import com.example.cooling.repository.InvoiceRepository;
import com.example.cooling.repository.PurchaseOrderRepository;

@Service
public class ReportService {

    @Autowired
    private InvoiceRepository invoiceRepo;

    @Autowired
    private PurchaseOrderRepository poRepo;

    public ReportResponse getProfitLossReport() {

        double revenue = invoiceRepo.findAll()
                .stream()
                .mapToDouble(i -> i.getTotalAmount())
                .sum();

        double expense = poRepo.findAll()
                .stream()
                .mapToDouble(p -> p.getAmount())
                .sum();

        double profit = revenue - expense;

        return new ReportResponse(revenue, expense, profit);
    }
}