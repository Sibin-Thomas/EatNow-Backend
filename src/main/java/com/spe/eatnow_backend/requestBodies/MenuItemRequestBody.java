package com.spe.eatnow_backend.requestBodies;

public class MenuItemRequestBody {
    String name;
    Integer price;
    Integer restaurant_id;

    public MenuItemRequestBody(String name, Integer price, Integer restaurant_id) {
        this.name = name;
        this.price = price;
        this.restaurant_id = restaurant_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getRestaurant_id() {
        return restaurant_id;
    }

    public MenuItemRequestBody() {
    }

    public void setRestaurant_id(Integer restaurant_id) {
        this.restaurant_id = restaurant_id;
    }
}
