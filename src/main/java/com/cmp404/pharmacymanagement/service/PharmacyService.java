package com.cmp404.pharmacymanagement.service;

import com.cmp404.pharmacymanagement.exception.ResourceNotFoundException;
import com.cmp404.pharmacymanagement.model.Pharmacy;
import com.cmp404.pharmacymanagement.repository.PharmacyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PharmacyService {

    private final PharmacyRepository pharmacyRepository;

    @Autowired
    public PharmacyService(PharmacyRepository pharmacyRepository) {
        this.pharmacyRepository = pharmacyRepository;
    }

    public List<Pharmacy> getPharmacies() {
        return pharmacyRepository.findAll();
    }

    public Pharmacy getPharmacyById(Long id) {
        return pharmacyRepository.findPharmacyById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pharmacy ID#" + id + " was not found."));
    }

    public Pharmacy addPharmacy(Pharmacy pharmacy) {
        return pharmacyRepository.save(pharmacy);
    }

    public Pharmacy updatePharmacy(Pharmacy pharmacy) {
        return pharmacyRepository.save(pharmacy);
    }

    public void deletePharmacy(Long id) {
        boolean exists = pharmacyRepository.existsById(id);
        if(!exists) {
            throw new IllegalStateException("Pharmacy ID#" + id + " does not exist.");
        }
        pharmacyRepository.deleteById(id);
    }
}
