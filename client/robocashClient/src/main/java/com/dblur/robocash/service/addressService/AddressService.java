package com.dblur.robocash.service.addressService;

import model.Address;

public interface AddressService {

    void add(Address address);
    void delete(Long id);
    void edit(Address address);

}
