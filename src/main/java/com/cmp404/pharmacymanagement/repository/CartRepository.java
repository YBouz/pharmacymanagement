package com.cmp404.pharmacymanagement.repository;

import com.cmp404.pharmacymanagement.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findCartByCustomerId(Long customerId);
}
