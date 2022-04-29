package com.spe.eatnow_backend.requestBodies;

public class DiningItemRequestBody {
    String slot;
    Integer restaurantId;
    Integer price;

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public DiningItemRequestBody(String slot, Integer restaurantId, Integer price) {
        this.slot = slot;
        this.restaurantId = restaurantId;
        this.price = price;
    }
}
