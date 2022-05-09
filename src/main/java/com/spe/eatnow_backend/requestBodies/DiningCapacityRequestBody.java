package com.spe.eatnow_backend.requestBodies;

public class DiningCapacityRequestBody {
    private Integer restaurantId;
    private Integer capacity;

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public DiningCapacityRequestBody(Integer restaurantId, Integer capacity) {
        this.restaurantId = restaurantId;
        this.capacity = capacity;
    }

    public DiningCapacityRequestBody() {
    }
}
