package com.example.cooling.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class BudgetResponse {

    private double plannedBudget;
    private double actualExpense;
    private double remainingBudget;
}