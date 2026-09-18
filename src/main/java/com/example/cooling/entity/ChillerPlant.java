package com.example.cooling.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "chiller_plants")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ChillerPlant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long plantId;

    private String plantName;

    private String location;

    private Double iceStorageCapacity;

    private String status;
}