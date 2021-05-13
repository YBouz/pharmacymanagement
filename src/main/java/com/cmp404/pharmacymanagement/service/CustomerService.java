package com.cmp404.pharmacymanagement.service;

import com.cmp404.pharmacymanagement.exception.ResourceNotFoundException;
import com.cmp404.pharmacymanagement.model.Customer;
import com.cmp404.pharmacymanagement.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findCustomerById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer ID#" + id + " was not found."));
    }

    public Customer addCustomer(Customer customer) {
        Optional<Customer> customerOptional = customerRepository.findCustomerByEmail(customer.getEmail());

        if(customerOptional.isPresent()) {
            throw new IllegalStateException("Email is already in use.");
        }
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Long id) {
        boolean exists = customerRepository.existsById(id);
        if(!exists) {
            throw new IllegalStateException("Customer ID#" + id + " does not exist.");
        }
        customerRepository.deleteById(id);
    }
}
