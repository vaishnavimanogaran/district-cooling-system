package com.example.cooling.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.cooling.entity.PurchaseOrder;
import com.example.cooling.service.PurchaseOrderService;

@RestController
@RequestMapping("/api/purchase-orders")
public class PurchaseOrderController {

    @Autowired
    private PurchaseOrderService service;

    @PostMapping
    public PurchaseOrder addPO(@RequestBody PurchaseOrder po) {
        return service.savePO(po);
    }

    @GetMapping
    public List<PurchaseOrder> getAllPO() {
        return service.getAllPO();
    }
}