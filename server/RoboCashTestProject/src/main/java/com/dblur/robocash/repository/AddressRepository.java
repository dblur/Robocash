package com.dblur.robocash.repository;

import com.dblur.robocash.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    Address findAddressById(Long id); //поиск адреса по id. нужен для удаления.

    boolean existsAddressByCountryAndCityAndStreetAndHouseAndFlat(String country, //проверка адреса на существование
                                                                  String city,
                                                                  String street,
                                                                  String house,
                                                                  String flat);
}
