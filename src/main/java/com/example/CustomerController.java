package com.example;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class CustomerController {

    private static final String template = "Hello, %s!";
    
    private CustomerRepository repository;

    @Autowired
    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/customer")
    public HttpEntity<Customer> getCustomer(@RequestParam(required=false, defaultValue="Customer") String name) {
        System.out.println("==== in customer ====");
        
        List<Customer> records = repository.findByLastName(name);
        Customer customer = new Customer("Hello", String.format(template, records.toString()));
        
        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }

}