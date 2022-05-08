package com.spe.eatnow_backend.entities;b

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer orderId;

    public String status;
    
    public Integer orderNumber;

//    public Integer userId;
//
//    public Integer getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Integer userId) {
//        this.userId = userId;
//    }
//
//    public Integer restaurantId;
//
//    public Integer getRestaurantId() {
//        return restaurantId;
//    }
//
//    public void setRestaurantId(Integer restaurantId) {
//        this.restaurantId = restaurantId;
//    }
//    public Orders(Integer userId, String status, Integer orderNumber, Integer restaurantId, Integer total) {
//        this.userId = userId;
//        this.status = status;
//        this.orderNumber = orderNumber;
//        this.restaurantId = restaurantId;
//        this.total = total;
//    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private User restaurant;

    @JsonBackReference
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @JsonBackReference
    public User getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(User restaurant) {
        this.restaurant = restaurant;
    }

    public Orders(String status, Integer orderNumber, User user, User restaurant, Integer total) {
        this.status = status;
        this.orderNumber = orderNumber;
        this.user = user;
        this.restaurant = restaurant;
        this.total = total;
    }

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

}
