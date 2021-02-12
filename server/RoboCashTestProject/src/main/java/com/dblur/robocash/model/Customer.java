package com.dblur.robocash.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "registred_address_id")
    private Address registred_address_id;

    @ManyToOne
    @JoinColumn(name = "actual_address_id")
    private Address actual_address_id;

    @Column(name = "first_name")
    private String firstname;

    @Column(name = "last_name")
    private String lastname;

    @Column(name = "middle_name")
    private String middlename;

    @Column(name = "sex")
    private String sex;
}
