package com.order.process.app.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "order", schema = "orderprocessing")
public class Order implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "order_id")
    private String orderId;

    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "order_status")
    private String orderStatus;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "modified_on")
    private Date modifiedOn;

    @Column(name = "completed_on")
    private Date completedOn;

    @Column(name = "item_id")
    private String itemId;

    @Column(name = "item_quantity")
    private int itemQuantity;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "billing_address_id")
    private Long billingAddressId;

    @Column(name = "order_subtotal")
    private double orderSubtotal;

    @Column(name = "order_tax")
    private double orderTax;

    @Column(name = "order_total")
    private double orderTotal;

    @Column(name = "shipping_address_id")
    private Long shippingAddressId;

    public Order() {

    }

    /**
     * @param orderId
     * @param customerId
     * @param orderStatus
     * @param createdOn
     * @param modifiedOn
     * @param completedOn
     * @param itemId
     * @param itemQuantity
     * @param paymentMethod
     * @param billingAddressId
     * @param orderSubtotal
     * @param orderTax
     * @param orderTotal
     * @param shippingAddressId
     */
    public Order(String orderId, String customerId, String orderStatus, Date createdOn, Date modifiedOn,
                 Date completedOn, String itemId, int itemQuantity, String paymentMethod, Long billingAddressId,
                 double orderSubtotal, double orderTax, double orderTotal, Long shippingAddressId) {
        super();
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderStatus = orderStatus;
        this.createdOn = createdOn;
        this.modifiedOn = modifiedOn;
        this.completedOn = completedOn;
        this.itemId = itemId;
        this.itemQuantity = itemQuantity;
        this.paymentMethod = paymentMethod;
        this.billingAddressId = billingAddressId;
        this.orderSubtotal = orderSubtotal;
        this.orderTax = orderTax;
        this.orderTotal = orderTotal;
        this.shippingAddressId = shippingAddressId;
    }

    /**
     * @return the orderId
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * @return the customerId
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * @return the orderStatus
     */
    public String getOrderStatus() {
        return orderStatus;
    }

    /**
     * @param orderStatus the orderStatus to set
     */
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * @return the createdOn
     */
    public Date getCreatedOn() {
        return createdOn;
    }

    /**
     * @param createdOn the createdOn to set
     */
    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    /**
     * @return the modifiedOn
     */
    public Date getModifiedOn() {
        return modifiedOn;
    }

    /**
     * @param modifiedOn the modifiedOn to set
     */
    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    /**
     * @return the completedOn
     */
    public Date getCompletedOn() {
        return completedOn;
    }

    /**
     * @param completedOn the completedOn to set
     */
    public void setCompletedOn(Date completedOn) {
        this.completedOn = completedOn;
    }

    /**
     * @return the itemId
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * @param itemId the itemId to set
     */
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    /**
     * @return the itemQuantity
     */
    public int getItemQuantity() {
        return itemQuantity;
    }

    /**
     * @param itemQuantity the itemQuantity to set
     */
    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    /**
     * @return the paymentMethod
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * @param paymentMethod the paymentMethod to set
     */
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    /**
     * @return the billingAddressId
     */
    public Long getBillingAddressId() {
        return billingAddressId;
    }

    /**
     * @param billingAddressId the billingAddressId to set
     */
    public void setBillingAddressId(Long billingAddressId) {
        this.billingAddressId = billingAddressId;
    }

    /**
     * @return the orderSubtotal
     */
    public double getOrderSubtotal() {
        return orderSubtotal;
    }

    /**
     * @param orderSubtotal the orderSubtotal to set
     */
    public void setOrderSubtotal(double orderSubtotal) {
        this.orderSubtotal = orderSubtotal;
    }

    /**
     * @return the orderTax
     */
    public double getOrderTax() {
        return orderTax;
    }

    /**
     * @param orderTax the orderTax to set
     */
    public void setOrderTax(double orderTax) {
        this.orderTax = orderTax;
    }

    /**
     * @return the orderTotal
     */
    public double getOrderTotal() {
        return orderTotal;
    }

    /**
     * @param orderTotal the orderTotal to set
     */
    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    /**
     * @return the shippingAddressId
     */
    public Long getShippingAddressId() {
        return shippingAddressId;
    }

    /**
     * @param shippingAddressId the shippingAddressId to set
     */
    public void setShippingAddressId(Long shippingAddressId) {
        this.shippingAddressId = shippingAddressId;
    }

    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", customerId=" + customerId + ", orderStatus=" + orderStatus
                + ", createdOn=" + createdOn + ", modifiedOn=" + modifiedOn + ", completedOn=" + completedOn
                + ", itemId=" + itemId + ", itemQuantity=" + itemQuantity + ", paymentMethod=" + paymentMethod
                + ", billingAddressId=" + billingAddressId + ", orderSubtotal=" + orderSubtotal + ", orderTax="
                + orderTax + ", orderTotal=" + orderTotal + ", shippingAddressId=" + shippingAddressId + "]";
    }

}
