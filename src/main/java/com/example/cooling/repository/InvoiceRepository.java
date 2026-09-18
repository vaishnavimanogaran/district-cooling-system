package com.example.cooling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.cooling.entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}