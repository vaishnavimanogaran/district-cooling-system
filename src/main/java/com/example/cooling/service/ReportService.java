package com.example.cooling.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.cooling.dto.BudgetResponse;
import com.example.cooling.dto.DashboardResponse;
import com.example.cooling.dto.ReportResponse;
import com.example.cooling.repository.ChillerPlantRepository;
import com.example.cooling.repository.CustomerRepository;
import com.example.cooling.repository.InvoiceRepository;
import com.example.cooling.repository.PurchaseOrderRepository;
import com.example.cooling.repository.VendorRepository;

@Service
public class ReportService {

    @Autowired
    private InvoiceRepository invoiceRepo;

    @Autowired
    private PurchaseOrderRepository poRepo;
    
    @Autowired
    private CustomerRepository customerRepo;

    @Autowired
    private ChillerPlantRepository plantRepo;

    @Autowired
    private VendorRepository vendorRepo;

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
    public BudgetResponse getBudgetReport() {

        double planned = 100000;

        double expense = poRepo.findAll()
                .stream()
                .mapToDouble(p -> p.getAmount())
                .sum();

        return new BudgetResponse(
                planned,
                expense,
                planned - expense);
    }
      
    public DashboardResponse getDashboard() {

        double revenue = invoiceRepo.findAll()
                .stream()
                .mapToDouble(i -> i.getTotalAmount())
                .sum();

        double expense = poRepo.findAll()
                .stream()
                .mapToDouble(p -> p.getAmount())
                .sum();

        return new DashboardResponse(
                customerRepo.count(),
                plantRepo.count(),
                vendorRepo.count(),
                revenue,
                expense,
                revenue - expense
        );
    }
    }
