package com.example.cooling.entity;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.*;

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

    @NotBlank
    private String plantName;

    @NotBlank
    private String location;

    @NotNull
    @Positive
    private Double iceStorageCapacity;

    @NotBlank
    private String status;
}