package com.example.cooling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.cooling.entity.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Long> {

}