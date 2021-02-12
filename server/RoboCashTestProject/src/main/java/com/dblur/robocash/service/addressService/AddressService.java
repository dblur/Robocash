package com.dblur.robocash.service.addressService;

import com.dblur.robocash.model.Address;

public interface AddressService {

    void add(Address address);
    void delete(Long id);
    void edit(Address address);

}
