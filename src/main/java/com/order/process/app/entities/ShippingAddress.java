package com.order.process.app.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ShippingAddress {

    @Id
    private Integer shippingAddressId;

    private String customerId;

    private String shippingAddressline1;

    private String shippingAddressline2;

    private String shippingCity;

    private String shippingState;

    private String shippingZip;

    private String shippingMethod;

}
