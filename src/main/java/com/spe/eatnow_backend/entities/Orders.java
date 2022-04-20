package com.spe.eatnow_backend.entities;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer orderId;

    public Integer userId;

    public String status;
    
    public Integer orderNumber;

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer total;

    public Integer getorderId() {
        return orderId;
    }

    public void setorderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Orders() {
    }

    public Orders(Integer orderId, Integer userId, String status, Integer total) {
        this.orderId = orderId;
        this.userId = userId;
        this.status = status;
        this.total = total;
    }
}