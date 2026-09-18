package com.example.cooling.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "telemetry")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Telemetry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long telemetryId;

    private Double flowRate;

    private Double tempDelta;

    private Double tonHours;

    private LocalDateTime readingTime;

    @ManyToOne
    @JoinColumn(name = "plant_id")
    private ChillerPlant chillerPlant;
}