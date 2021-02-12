package com.dblur.robocash.service.addressService;

import model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AddressRESTServiceImpl implements AddressService{

    @Value("${central.server.url}") //ссылка на центральный адрес сервера. указывается в application.properties
    private String CENTRAL_SERVER_URL;

    private final RestTemplate restTemplate;

    @Autowired
    public AddressRESTServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Async
    @Override
    public void add(Address address) { //метод добавления сущности адреса
        HttpEntity<Address> httpEntity = new HttpEntity<>(address);
        restTemplate.postForEntity(CENTRAL_SERVER_URL + "/addAddress", httpEntity, Address.class);
    }

    @Async
    @Override
    public void delete(Long id) { //удаление сущности адреса
        restTemplate.delete(CENTRAL_SERVER_URL + "/deleteAddress/" + id);
    }

    @Async
    @Override
    public void edit(Address address) { //редактирование сущности адреса
        restTemplate.put(CENTRAL_SERVER_URL + "/editAddress/", address);
    }
}
