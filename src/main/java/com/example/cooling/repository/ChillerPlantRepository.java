package com.example.cooling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.cooling.entity.ChillerPlant;

public interface ChillerPlantRepository extends JpaRepository<ChillerPlant, Long> {
	
}

