package com.dblur.robocash.service.customerService;

import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class CustomerRESTServiceImpl implements CustomerService {

    @Value("${central.server.url}") //ссылка на центральный адрес сервера. указывается в application.properties
    private String CENTRAL_SERVER_URL;

    private final RestTemplate restTemplate;

    @Autowired
    public CustomerRESTServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Customer getCustomerByFirstNameAndLastName(String firstname, String lastname) { //метод получения сущности пользователя по имени и фамилии
        ResponseEntity<Customer> responseEntity = restTemplate.
                getForEntity(CENTRAL_SERVER_URL + "/customer/" + firstname + "/" + lastname, Customer.class);
        return responseEntity.getBody();
    }

    @Async
    @Override
    public void add(Customer customer) { //метод добавления сущности пользователя
        HttpEntity<Customer> httpEntity = new HttpEntity<>(customer);
        restTemplate.postForEntity(CENTRAL_SERVER_URL + "/addCustomer", httpEntity, Customer.class);
    }

    @Async
    @Override
    public void delete(Long id) { //метод удаления сущности пользователя по id
        restTemplate.delete(CENTRAL_SERVER_URL + "/deleteCustomer/" + id, Customer.class);
    }

    @Async
    @Override
    public void edit(Customer customer) { //метод редактирования имеющегося пользователя
        restTemplate.put(CENTRAL_SERVER_URL + "/editCustomer", customer);
    }
}
