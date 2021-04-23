package com.order.process.app.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {

    @Id
    private String customerId;

    private String firstName;

    private String lastName;

    private String email;

    private String mailingAddress;

}
