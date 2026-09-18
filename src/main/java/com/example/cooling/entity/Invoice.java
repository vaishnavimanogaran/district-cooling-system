package com.example.cooling.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "invoices")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invoiceId;

    private String invoiceDate;

    private Double tonHours;

    private Double ratePerTon;

    private Double totalAmount;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}