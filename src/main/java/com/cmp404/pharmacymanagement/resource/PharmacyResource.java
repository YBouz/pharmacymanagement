package com.cmp404.pharmacymanagement.resource;

import com.cmp404.pharmacymanagement.model.Customer;
import com.cmp404.pharmacymanagement.model.Pharmacy;
import com.cmp404.pharmacymanagement.service.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/pharmacy")
public class PharmacyResource {

    private final PharmacyService pharmacyService;

    @Autowired
    public PharmacyResource(PharmacyService pharmacyService) {
        this.pharmacyService = pharmacyService;
    }

    @GetMapping
    public ResponseEntity<List<Pharmacy>> getPharmacies() {
        List<Pharmacy> pharmacies = pharmacyService.getPharmacies();
        return new ResponseEntity<>(pharmacies, HttpStatus.OK);
    }

    @GetMapping(path = "{pharmacyId}")
    public ResponseEntity<Pharmacy> getPharmacyById(@PathVariable("pharmacyId") Long id) {
        Pharmacy pharmacy = pharmacyService.getPharmacyById(id);
        return new ResponseEntity<>(pharmacy, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Pharmacy> addPharmacy(@RequestBody Pharmacy p) {
        Pharmacy pharmacy = pharmacyService.addPharmacy(p);
        return new ResponseEntity<>(pharmacy, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Pharmacy> updatePharmacy(@RequestBody Pharmacy p) {
        Pharmacy pharmacy = pharmacyService.updatePharmacy(p);
        return new ResponseEntity<>(pharmacy, HttpStatus.OK);
    }

    @DeleteMapping(path = "{pharmacyId}")
    public ResponseEntity<?> deletePharmacy(@PathVariable("pharmacyId") Long id) {
        pharmacyService.deletePharmacy(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
