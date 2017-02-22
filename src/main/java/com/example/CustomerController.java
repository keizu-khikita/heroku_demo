package com.example;

//import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
//import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    private static final String template = "Hello, %s!";

    @GetMapping("/greeting")
    public HttpEntity<Customer> getCustomer(@RequestParam(required=false, defaultValue="Customer") String name) {
        System.out.println("==== in customer ====");
        
        Customer customer = new Customer("Hello", String.format(template, name));
        
        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }

}