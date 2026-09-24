package com.example.cooling.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DashboardResponse {

    private long totalCustomers;
    private long totalPlants;
    private long totalVendors;

    private double totalRevenue;
    private double totalExpense;
    private double netProfit;
}