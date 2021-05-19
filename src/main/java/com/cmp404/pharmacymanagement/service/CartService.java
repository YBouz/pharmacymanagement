package com.cmp404.pharmacymanagement.service;

import com.cmp404.pharmacymanagement.exception.ResourceNotFoundException;
import com.cmp404.pharmacymanagement.model.Cart;
import com.cmp404.pharmacymanagement.repository.CartRepository;
import com.cmp404.pharmacymanagement.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CartService {

    private final CartRepository cartRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public CartService(CartRepository cartRepository, CustomerRepository customerRepository) {
        this.cartRepository = cartRepository;
        this.customerRepository = customerRepository;
    }

    public List<Cart> getCarts() {
        return cartRepository.findAll();
    }

    public Cart getCart(Long id) {
        return cartRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cart #" + id + " was not found."));
    }

    public Cart getCartByCustomerId(Long customerId) {
        return cartRepository.findCartByCustomerId(customerId);
    }

    public Cart addCart(Long customerId) {
        return customerRepository.findById(customerId).map(customer -> {
            Cart cart = new Cart();
            cart.setCustomer(customer);
            return cartRepository.save(cart);
        }).orElseThrow(() -> new ResourceNotFoundException("Customer ID#" + customerId + " was not found."));
    }

    public Cart updateCart(Long customerId, Long cartId, Cart c) {
        boolean exists = customerRepository.existsById(customerId);
        if(!exists) {
            throw new ResourceNotFoundException("Customer ID#" + customerId + " was not found.");
        }

        return cartRepository.findById(cartId).map(cart -> {
            //TO-DO if any cart update logic is required
            return cartRepository.save(c);
        }).orElseThrow(() -> new ResourceNotFoundException("Cart ID#" + cartId + " was not found."));
    }

    public void deleteCart(Long cartId) {
        boolean exists = cartRepository.existsById(cartId);
        if(!exists) {
            throw new IllegalStateException("Cart ID#" + cartId + " was not found.");
        }
        cartRepository.deleteById(cartId);
    }
}
