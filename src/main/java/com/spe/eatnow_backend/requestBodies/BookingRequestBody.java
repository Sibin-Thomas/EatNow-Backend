package com.spe.eatnow_backend.requestBodies;

public class BookingRequestBody {
    private Integer restaurantId;
    private Integer userId;
    private String datetime;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public BookingRequestBody() {
    }

    public BookingRequestBody(Integer restaurantId, Integer userId, String datetime) {
        this.restaurantId = restaurantId;
        this.userId = userId;
        this.datetime = datetime;
    }
}
