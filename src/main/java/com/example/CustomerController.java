package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    private static final String template = "Hello, %s!";

    @GetMapping("/greeting")
    public Customer getCustomer(@RequestParam(required=false, defaultValue="Customer") String name) {
        System.out.println("==== in customer ====");
        return new Customer("Hello", String.format(template, name));
    }

}