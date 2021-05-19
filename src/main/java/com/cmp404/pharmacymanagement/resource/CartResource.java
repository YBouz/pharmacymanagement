package com.cmp404.pharmacymanagement.resource;

import com.cmp404.pharmacymanagement.model.Cart;
import com.cmp404.pharmacymanagement.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class CartResource {

    private final CartService cartService;

    @Autowired
    public CartResource(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping(path = "/api/cart")
    public ResponseEntity<List<Cart>> getCarts() {
        List<Cart> carts = cartService.getCarts();
        return new ResponseEntity<>(carts, HttpStatus.OK);
    }

    @GetMapping(path = "/api/cart/{cartId}")
    public ResponseEntity<Cart> getCart(@PathVariable("cartId") Long id) {
        Cart cart = cartService.getCart(id);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @GetMapping(path = "api/customer/{customerId}/cart")
    public ResponseEntity<Cart> getCartByCustomer(@PathVariable("customerId") Long customerId) {
        Cart cart = cartService.getCartByCustomerId(customerId);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @PostMapping(path = "api/customer/{customerId}/cart")
    public ResponseEntity<Cart> addCart(@PathVariable("customerId") Long customerId) {
        Cart cart = cartService.addCart(customerId);
        return new ResponseEntity<>(cart, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/api/cart/{cartId}")
    public ResponseEntity<?> deleteCart(@PathVariable("cartId") Long cartId) {
        cartService.deleteCart(cartId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
