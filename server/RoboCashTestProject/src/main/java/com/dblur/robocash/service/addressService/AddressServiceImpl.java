package com.dblur.robocash.service.addressService;

import com.dblur.robocash.model.Address;
import com.dblur.robocash.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Async
    @Override
    public void add(Address address) {
        if (addressRepository.existsAddressByCountryAndCityAndStreetAndHouseAndFlat(
                address.getCountry(),
                address.getCity(),
                address.getStreet(),
                address.getHouse(),
                address.getFlat())) {
            addressRepository.save(address);
        } else System.out.println("New address not saved. Address exist");

    }

    @Async
    @Override
    public void delete(Long id) {
        addressRepository.delete(addressRepository.findAddressById(id));
    }

    @Async
    @Override
    public void edit(Address address) {
        if (addressRepository.existsAddressByCountryAndCityAndStreetAndHouseAndFlat(
                address.getCountry(),
                address.getCity(),
                address.getStreet(),
                address.getHouse(),
                address.getFlat())) {
            addressRepository.saveAndFlush(address);
        } else System.out.println("Address exist");
    }
}
