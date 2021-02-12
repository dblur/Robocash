package com.dblur.robocash.controllers;

import com.dblur.robocash.service.customerService.CustomerRESTServiceImpl;
import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    private final CustomerRESTServiceImpl customerService;

    @Autowired
    public CustomerController(CustomerRESTServiceImpl customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customer/{firstname}/{lastname}")
    public Customer getCustomerByFirstnameAndLastname(@PathVariable String firstname,
                                                      @PathVariable String lastname) {
        return customerService.getCustomerByFirstNameAndLastName(firstname, lastname);
    }

    @PostMapping("/add/customer")
    public String addCustomer(@RequestBody Customer customer) {
        customerService.add(customer);
        return "success";
    }

    @PutMapping("/edit/customer")
    public String editCustomer(@RequestBody Customer customer) {
        customerService.edit(customer);
        return "success";
    }

    @DeleteMapping("/delete/customer/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        customerService.delete(id);
        return "success";
    }
}
