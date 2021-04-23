package com.order.process.app.services.rest.models;

import com.fasterxml.jackson.annotation.JsonRootName;

import java.sql.Date;

@JsonRootName("order")
public class RestOrder {

    public String orderId;
    public String customerId;
    public String orderStatus;
    public Date createdOn;
    public Date modifiedOn;
    public Date completedOn;
    public String itemId;
    public int itemQuantity;
    public String paymentMethod;
    public Long billingAddressId;
    public double orderSubtotal;
    public double orderTax;
    public double orderTotal;
    public Long shippingAddressId;

    public RestOrder() {

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
        return "RestOrder [orderId=" + orderId + ", customerId=" + customerId + ", orderStatus=" + orderStatus
                + ", createdOn=" + createdOn + ", modifiedOn=" + modifiedOn + ", completedOn=" + completedOn
                + ", itemId=" + itemId + ", itemQuantity=" + itemQuantity + ", paymentMethod=" + paymentMethod
                + ", billingAddressId=" + billingAddressId + ", orderSubtotal=" + orderSubtotal + ", orderTax="
                + orderTax + ", orderTotal=" + orderTotal + ", shippingAddressId=" + shippingAddressId + "]";
    }

}
