package com.order.process.app.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Item {

    @Id
    private String itemId;

    private String itemName;

    private String itemDiscription;

}
