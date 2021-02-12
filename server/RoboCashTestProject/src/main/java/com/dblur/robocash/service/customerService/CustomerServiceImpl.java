package com.dblur.robocash.service.customerService;

import com.dblur.robocash.model.Customer;
import com.dblur.robocash.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer getCustomerByFirstnameAndLastname(String firstname, String lastname) {
        return customerRepository.findCustomerByFirstnameAndLastname(firstname, lastname);
    }

    @Async
    @Override
    public void add(Customer customer) {
        customerRepository.save(customer);
    }

    @Async
    @Override
    public void delete(Long id) {
        customerRepository.delete(customerRepository.findCustomerById(id));
    }

    @Async
    @Override
    public void edit(Customer customer) {
        customerRepository.saveAndFlush(customer);
    }
}
