package com.example.cooling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.cooling.dto.BudgetResponse;
import com.example.cooling.dto.DashboardResponse;
import com.example.cooling.dto.ReportResponse;
import com.example.cooling.service.ReportService;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private ReportService service;

    @GetMapping("/profit-loss")
    public ReportResponse getReport() {
        return service.getProfitLossReport();
    }

    @GetMapping("/budget")
    public BudgetResponse budget() {
        return service.getBudgetReport();
    }

    @GetMapping("/dashboard")
    public DashboardResponse dashboard() {
        return service.getDashboard();
    }
}