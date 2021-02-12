package model;

import lombok.Data;

@Data
public class Address {

    private Long id;
    private String country;
    private String region;
    private String city;
    private String street;
    private String house;
    private String flat;

}
