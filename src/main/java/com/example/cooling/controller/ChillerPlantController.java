package com.example.cooling.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.cooling.entity.ChillerPlant;
import com.example.cooling.service.ChillerPlantService;

@RestController
@RequestMapping("/api/plants")
public class ChillerPlantController {

    @Autowired
    private ChillerPlantService service;

    @PostMapping
    public ChillerPlant addPlant(@RequestBody ChillerPlant plant) {
        return service.savePlant(plant);
    }

    @GetMapping
    public List<ChillerPlant> getAllPlants() {
        return service.getAllPlants();
    }

    @GetMapping("/{id}")
    public ChillerPlant getPlantById(@PathVariable Long id) {
        return service.getPlantById(id);
    }

    @DeleteMapping("/{id}")
    public String deletePlant(@PathVariable Long id) {
        service.deletePlant(id);
        return "Plant deleted successfully";
    }
}