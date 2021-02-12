package com.dblur.robocash.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "country")
    private String country;

    @Column(name = "region")
    private String region;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "house")
    private String house;

    @Column(name = "flat")
    private String flat;

    @JsonIgnore
    @OneToMany(mappedBy = "registred_address_id")
    private List<Customer> customerList;

    @JsonIgnore
    @OneToMany(mappedBy = "actual_address_id")
    private List<Customer> customerList2;

}
