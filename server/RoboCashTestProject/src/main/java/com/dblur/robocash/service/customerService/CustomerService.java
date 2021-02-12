package com.dblur.robocash.service.customerService;

import com.dblur.robocash.model.Customer;

public interface CustomerService {

    Customer getCustomerByFirstnameAndLastname(String firstname, String lastname);

    void add(Customer customer);
    void delete(Long id);
    void edit(Customer customer);
}
