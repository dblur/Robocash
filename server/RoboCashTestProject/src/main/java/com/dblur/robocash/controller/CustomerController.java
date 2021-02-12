package com.dblur.robocash.controller;

import com.dblur.robocash.model.Customer;
import com.dblur.robocash.service.customerService.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping("/customer/{firstname}/{lastname}")
    public ResponseEntity<Customer> getCustomerByFirstNameAndLastName(@PathVariable String firstname,
                                                                      @PathVariable String lastname) { //получаем параметры firstname и lastname
        Customer customer = customerService.getCustomerByFirstnameAndLastname(firstname, lastname);
        if (customer != null) {
            return ResponseEntity.status(HttpStatus.OK).body(customer); //если такой пользователь существует - возвращаем в виде json
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/addCustomer")
    @Transactional
    public ResponseEntity<Customer> addCustomer(HttpEntity<Customer> httpEntity) {
        Customer customer = httpEntity.getBody(); //получаем тело в виде json
        customerService.add(customer); //и записываем его в бд
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/editCustomer")
    public ResponseEntity<Customer> editCustomer(HttpEntity<Customer> httpEntity) {
        Customer customer = httpEntity.getBody();
        customerService.edit(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteCustomer/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable Long id) {
        customerService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
