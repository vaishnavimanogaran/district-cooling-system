package com.example.cooling.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cooling.entity.ChillerPlant;
import com.example.cooling.repository.ChillerPlantRepository;

@Service
public class ChillerPlantService {

    @Autowired
    private ChillerPlantRepository repository;

    // Add Plant
    public ChillerPlant savePlant(ChillerPlant plant) {
        return repository.save(plant);
    }

    // Get All Plants
    public List<ChillerPlant> getAllPlants() {
        return repository.findAll();
    }

    // Get Plant by ID
    public ChillerPlant getPlantById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // Delete Plant
    public void deletePlant(Long id) {
        repository.deleteById(id);
    }
}