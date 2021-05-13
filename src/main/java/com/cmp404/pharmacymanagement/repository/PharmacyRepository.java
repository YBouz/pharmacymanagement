package com.cmp404.pharmacymanagement.repository;

import com.cmp404.pharmacymanagement.model.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PharmacyRepository extends JpaRepository<Pharmacy, Long> {

    Optional<Pharmacy> findPharmacyById(Long id);
    Optional<Pharmacy> findPharmacyByAddress(String address);
}
