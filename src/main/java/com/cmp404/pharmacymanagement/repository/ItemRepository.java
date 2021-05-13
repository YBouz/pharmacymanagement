package com.cmp404.pharmacymanagement.repository;

import com.cmp404.pharmacymanagement.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    //List<Item> findByPharmacy(Pharmacy pharmacy, Sort sort);

    List<Item> findItemsByPharmacyId(Long pharmacyId);
}
