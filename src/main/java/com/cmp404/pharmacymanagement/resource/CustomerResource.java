package com.cmp404.pharmacymanagement.resource;

import com.cmp404.pharmacymanagement.model.Customer;
import com.cmp404.pharmacymanagement.service.CartService;
import com.cmp404.pharmacymanagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/customer")
public class CustomerResource {

    private final CustomerService customerService;
    private final CartService cartService;

    @Autowired
    public CustomerResource(CustomerService customerService, CartService cartService) {
        this.customerService = customerService;
        this.cartService = cartService;
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getCustomers() {
        List<Customer> customers = customerService.getCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping(path = "{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("customerId") Long id) {
        Customer customer = customerService.getCustomerById(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer c) {
        Customer customer = customerService.addCustomer(c);
        cartService.addCart(customer.getId());
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer c) {
        Customer customer = customerService.updateCustomer(c);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @DeleteMapping(path = "{customerId}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("customerId") Long id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
