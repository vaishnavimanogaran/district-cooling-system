package com.example.cooling.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "purchase_orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PurchaseOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long poId;

    private String poNumber;

    private String materialName;

    private Integer quantity;

    private Double amount;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;
}