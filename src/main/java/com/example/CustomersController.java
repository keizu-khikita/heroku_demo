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
public class CustomersController {

    private static final String template = "Hello, %s!";
    
    private CustomersRepository repository;

    @Autowired
    public CustomersController(CustomersRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/customer")
    public HttpEntity<Customers> getCustomer(@RequestParam(required=false, defaultValue="Customer") String name) {
        System.out.println("==== in customer ====");
        
        List<Customers> records = repository.findAll();
        System.out.println(records.toString());
        Customers customer = new Customers("Hello", String.format(template, name));
        
        return new ResponseEntity<Customers>(customer, HttpStatus.OK);
    }

}