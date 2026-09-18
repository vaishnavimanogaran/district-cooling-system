package com.example.cooling.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cooling.entity.Customer;
import com.example.cooling.entity.Invoice;
import com.example.cooling.entity.Telemetry;
import com.example.cooling.repository.CustomerRepository;
import com.example.cooling.repository.InvoiceRepository;
import com.example.cooling.repository.TelemetryRepository;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepo;

    @Autowired
    private CustomerRepository customerRepo;

    @Autowired
    private TelemetryRepository telemetryRepo;

    private final double RATE_PER_TON = 500.0;

    public Invoice generateInvoice(Long customerId) {

        Customer customer = customerRepo.findById(customerId).orElseThrow();

        List<Telemetry> readings = telemetryRepo.findAll();

        double totalTonHours = readings.stream()
                .mapToDouble(Telemetry::getTonHours)
                .sum();

        Invoice invoice = new Invoice();

        invoice.setCustomer(customer);
        invoice.setInvoiceDate(LocalDate.now().toString());
        invoice.setTonHours(totalTonHours);
        invoice.setRatePerTon(RATE_PER_TON);
        invoice.setTotalAmount(totalTonHours * RATE_PER_TON);

        return invoiceRepo.save(invoice);
    }

    public List<Invoice> getAllInvoices() {
        return invoiceRepo.findAll();
    }
}