package com.example.cooling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.cooling.entity.PurchaseOrder;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {

}