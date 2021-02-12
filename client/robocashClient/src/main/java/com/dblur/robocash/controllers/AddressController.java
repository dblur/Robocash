package com.dblur.robocash.controllers;

import com.dblur.robocash.service.addressService.AddressRESTServiceImpl;
import model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressController {

    private final AddressRESTServiceImpl addressService;

    @Autowired
    public AddressController(AddressRESTServiceImpl addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/add/address")
    public String addAddress(@RequestBody Address address) {
        addressService.add(address);
        return "success";
    }

    @PutMapping("/edit/address")
    public String editAddress(@RequestBody Address address) {
        addressService.edit(address);
        return "success";
    }

    @DeleteMapping("/delete/address/{id}")
    public String deleteAddress(@PathVariable Long id) {
        addressService.delete(id);
        return "success";
    }
}
