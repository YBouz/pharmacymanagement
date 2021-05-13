package com.cmp404.pharmacymanagement.repository;

import com.cmp404.pharmacymanagement.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findCustomerById(Long id);

    @Query("SELECT c FROM Customer c WHERE c.email = ?1")
    Optional<Customer> findCustomerByEmail(String email);
}
