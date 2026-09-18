package com.example.cooling.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReportResponse {

    private double totalRevenue;
    private double totalExpense;
    private double netProfit;
}