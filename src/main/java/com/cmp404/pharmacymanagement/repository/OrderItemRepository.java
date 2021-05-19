package com.cmp404.pharmacymanagement.repository;

import com.cmp404.pharmacymanagement.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    OrderItem findOrderItemByCartId(Long cartId);
}
