package com.example.cooling.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vendors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vendorId;

    private String companyName;

    private String contactPerson;

    private String email;

    private String phone;

    private String materialSupplied;
}