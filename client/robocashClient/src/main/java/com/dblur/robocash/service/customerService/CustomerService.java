package com.dblur.robocash.service.customerService;

import model.Customer;

public interface CustomerService {

    Customer getCustomerByFirstNameAndLastName(String firstname, String lastname);

    void add(Customer customer);
    void delete(Long id);
    void edit(Customer customer);
}
