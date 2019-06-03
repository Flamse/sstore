package com.top.sstore.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private Integer orderId;

    private String addressee;

    private String orderAddress;

    private String orderAddressPhone;

    private BigDecimal orderPrice;

    private Integer orderStatus;

    private Date orderCreateTime;

    private Integer userId;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getAddressee() {
        return addressee;
    }

    public void setAddressee(String addressee) {
        this.addressee = addressee == null ? null : addressee.trim();
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress == null ? null : orderAddress.trim();
    }

    public String getOrderAddressPhone() {
        return orderAddressPhone;
    }

    public void setOrderAddressPhone(String orderAddressPhone) {
        this.orderAddressPhone = orderAddressPhone == null ? null : orderAddressPhone.trim();
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getOrderCreateTime() {
        return orderCreateTime;
    }

    public void setOrderCreateTime(Date orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}