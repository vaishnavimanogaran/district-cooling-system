package com.example.cooling.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.cooling.entity.Telemetry;
import com.example.cooling.service.TelemetryService;

@RestController
@RequestMapping("/api/telemetry")
public class TelemetryController {

    @Autowired
    private TelemetryService service;

    @PostMapping
    public Telemetry addTelemetry(@RequestBody Telemetry telemetry) {
        return service.saveTelemetry(telemetry);
    }

    @GetMapping
    public List<Telemetry> getAllTelemetry() {
        return service.getAllTelemetry();
    }
}