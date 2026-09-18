package com.example.cooling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.cooling.entity.Telemetry;

public interface TelemetryRepository extends JpaRepository<Telemetry, Long> {

}