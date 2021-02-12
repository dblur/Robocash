package com.dblur.robocash.controller;

import com.dblur.robocash.model.Address;
import com.dblur.robocash.service.addressService.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @Transactional
    @PostMapping("/addAddress")
    public ResponseEntity<Address> addAddress(HttpEntity<Address> httpEntity){
        Address address = httpEntity.getBody();
        addressService.add(address);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/editAddress")
    public ResponseEntity<Address> editAddress(HttpEntity<Address> httpEntity) {
        Address address = httpEntity.getBody();
        addressService.edit(address);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteAddress/{id}")
    public ResponseEntity<Address> deleteAddress(@PathVariable Long id) {
        addressService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
