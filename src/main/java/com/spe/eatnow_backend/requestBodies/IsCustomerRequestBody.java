package com.spe.eatnow_backend.requestBodies;

public class IsCustomerRequestBody {

    Integer userId;
    Integer restaurantId;

    public IsCustomerRequestBody() {
    }

    public IsCustomerRequestBody(Integer userId, Integer restaurantId) {
        this.userId = userId;
        this.restaurantId = restaurantId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }
}
