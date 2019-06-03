package com.top.sstore.pojo;

public class Cart {
    private Integer cartId;

    private Integer userId;

    private Integer servId;

    private Integer servNumber;

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getServId() {
        return servId;
    }

    public void setServId(Integer servId) {
        this.servId = servId;
    }

    public Integer getServNumber() {
        return servNumber;
    }

    public void setServNumber(Integer servNumber) {
        this.servNumber = servNumber;
    }
}