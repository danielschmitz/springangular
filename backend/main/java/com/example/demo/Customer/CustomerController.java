package com.example.demo.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerController() {
    }

    @GetMapping("/customers")
    public List<Customer> findAll() {
        return this.customerRepository.findAll();
    }
}
