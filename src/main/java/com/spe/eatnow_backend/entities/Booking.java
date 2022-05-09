package com.spe.eatnow_backend.entities;

import javax.persistence.*;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer bookingId;

    private Integer restaurantId;

    private Integer userId;

    private String datetime;

    public Booking(Integer bookingId, Integer restaurantId, Integer userId, String datetime) {
        this.bookingId = bookingId;
        this.restaurantId = restaurantId;
        this.userId = userId;
        this.datetime = datetime;
    }

    public Booking() {
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
}