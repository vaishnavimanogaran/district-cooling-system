package com.example.cooling.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.cooling.entity.PurchaseOrder;
import com.example.cooling.repository.PurchaseOrderRepository;

@Service
public class PurchaseOrderService {

    @Autowired
    private PurchaseOrderRepository repository;

    public PurchaseOrder savePO(PurchaseOrder po) {
        return repository.save(po);
    }

    public List<PurchaseOrder> getAllPO() {
        return repository.findAll();
    }
}