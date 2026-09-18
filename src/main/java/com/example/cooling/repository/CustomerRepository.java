package com.example.cooling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.cooling.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}