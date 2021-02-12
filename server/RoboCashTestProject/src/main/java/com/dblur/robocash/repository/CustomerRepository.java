package com.dblur.robocash.repository;

import com.dblur.robocash.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findAll();
    Customer findCustomerById(Long id); //поиск пользователя по id. нужен для удаления
    Customer findCustomerByFirstnameAndLastname(String firstname, String lastname); //поиск пользователя по имени и фамилии
}
