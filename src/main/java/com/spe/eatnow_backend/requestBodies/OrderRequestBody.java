package com.spe.eatnow_backend.requestBodies;

import java.util.ArrayList;

public class OrderRequestBody {
    Integer userId;
    ArrayList<Integer> menuItemIds;
    Integer orderTotal;
    Integer restaurantId;

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Integer getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(Integer orderTotal) {
        this.orderTotal = orderTotal;
    }

    public OrderRequestBody(ArrayList<Integer> menuItemIds, Integer orderTotal, Integer restaurantId) {
        this.menuItemIds = menuItemIds;
        this.orderTotal = orderTotal;
        this.restaurantId = restaurantId;
    }

    public Integer getuserId() {
        return userId;
    }

    public void setuserId(Integer userId) {
        this.userId = userId;
    }

    public ArrayList<Integer> getMenuItemIds() {
        return menuItemIds;
    }

    public void setMenuItemIds(ArrayList<Integer> menuItemIds) {
        this.menuItemIds = menuItemIds;
    }
}
