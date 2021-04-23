package com.order.process.app.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Payment {

    @Id
    private String paymentId;

    private String customerId;

    private String orderId;

    private String orderMethod;

    private Date paymentDate;

    private Integer paymentConfirmNumber;

}
