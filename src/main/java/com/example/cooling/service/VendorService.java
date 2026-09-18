package com.example.cooling.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.cooling.entity.Vendor;
import com.example.cooling.repository.VendorRepository;

@Service
public class VendorService {

    @Autowired
    private VendorRepository repository;

    public Vendor saveVendor(Vendor vendor) {
        return repository.save(vendor);
    }

    public List<Vendor> getAllVendors() {
        return repository.findAll();
    }

    public Vendor getVendorById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteVendor(Long id) {
        repository.deleteById(id);
    }
}