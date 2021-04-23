package com.order.process.app.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BillingAddress {

    @Id
    private Long billingAddressId;

    private Long customerId;

    private String billingAddressLine1;

    private String billingAddressLine2;

    private String billingCity;

    private String billingState;

    private String billingZip;
}
