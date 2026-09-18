package com.example.cooling.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.cooling.entity.Vendor;
import com.example.cooling.service.VendorService;

@RestController
@RequestMapping("/api/vendors")
public class VendorController {

    @Autowired
    private VendorService service;

    @PostMapping
    public Vendor addVendor(@RequestBody Vendor vendor) {
        return service.saveVendor(vendor);
    }

    @GetMapping
    public List<Vendor> getAllVendors() {
        return service.getAllVendors();
    }

    @GetMapping("/{id}")
    public Vendor getVendorById(@PathVariable Long id) {
        return service.getVendorById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteVendor(@PathVariable Long id) {
        service.deleteVendor(id);
        return "Vendor deleted successfully";
    }
}