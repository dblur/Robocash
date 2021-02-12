package model;

import lombok.Data;

@Data
public class Customer {

    private Long id;
    private Address registred_address_id;
    private Address actual_address_id;
    private String firstname;
    private String middlename;
    private String lastname;
    private String sex;
}
