package com.example.cooling.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.cooling.entity.Telemetry;
import com.example.cooling.repository.TelemetryRepository;
import java.time.LocalDateTime;

@Service
public class TelemetryService {

    @Autowired
    private TelemetryRepository repository;

    public Telemetry saveTelemetry(Telemetry telemetry) {

        double tonHours =
            (telemetry.getFlowRate() * telemetry.getTempDelta()) / 120;

        telemetry.setTonHours(tonHours);
        telemetry.setReadingTime(LocalDateTime.now());

        return repository.save(telemetry);
    }

    public List<Telemetry> getAllTelemetry() {
        return repository.findAll();
    }
}