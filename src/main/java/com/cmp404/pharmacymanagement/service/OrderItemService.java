package com.cmp404.pharmacymanagement.service;

import com.cmp404.pharmacymanagement.exception.ResourceNotFoundException;
import com.cmp404.pharmacymanagement.model.Item;
import com.cmp404.pharmacymanagement.model.OrderItem;
import com.cmp404.pharmacymanagement.repository.CartRepository;
import com.cmp404.pharmacymanagement.repository.ItemRepository;
import com.cmp404.pharmacymanagement.repository.OrderItemRepository;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Service
//@Transactional
public class OrderItemService {

//    private final OrderItemRepository orderItemRepository;
//    private final CartRepository cartRepository;
//    private final ItemRepository itemRepository;
//
//    @Autowired
//    public OrderItemService(OrderItemRepository orderItemRepository,
//                            CartRepository cartRepository,
//                            ItemRepository itemRepository) {
//        this.orderItemRepository = orderItemRepository;
//        this.cartRepository = cartRepository;
//        this.itemRepository = itemRepository;
//    }
//
//    public List<OrderItem> getOrderItems() {
//        return orderItemRepository.findAll();
//    }
//
//    public OrderItem getOrderItem(Long id) {
//        return orderItemRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Order Item #" + id + " was not found."));
//    }
//
//    public OrderItem getOrderItemByCartId(Long cartId) {
//        return orderItemRepository.findOrderItemByCartId(cartId);
//    }
//
//    public OrderItem addOrderItem(Long cartId, Long itemId) {
//        return cartRepository.findById(cartId).map(cart -> {
//            Item item = itemRepository.findById(itemId)
//                    .orElseThrow(() -> new ResourceNotFoundException("Item #" + itemId + " was not found."));
//            OrderItem orderItem = new OrderItem();
//            orderItem.setCart(cart);
//            orderItem.setItemId(item.getId());
//            orderItem.setItemName(item.getName());
//            orderItem.setItemDescription(item.getDescription());
//            orderItem.setItemPrice(item.getPrice());
//            orderItem.setOrderQuantity(Long.valueOf(1));
//            return orderItemRepository.save(orderItem);
//        }).orElseThrow(() -> new ResourceNotFoundException("Cart #" + cartId + " was not found."));
//    }
//
//    public void deleteOrderItem(Long orderItemId) {
//        boolean exists = orderItemRepository.existsById(orderItemId);
//        if(!exists) {
//            throw new IllegalStateException("Order Item #" + orderItemId + " was not found.");
//        }
//    }
}
