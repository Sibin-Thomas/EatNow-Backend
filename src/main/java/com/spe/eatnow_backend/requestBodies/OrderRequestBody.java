package com.spe.eatnow_backend.requestBodies;

import java.util.ArrayList;

public class OrderRequestBody {
    Integer userId;
    ArrayList<Integer> menuItemIds;
    Integer orderTotal;

    public Integer getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(Integer orderTotal) {
        this.orderTotal = orderTotal;
    }

    public OrderRequestBody(Integer userId, ArrayList<Integer> menuItemIds) {
        this.userId = userId;
        this.menuItemIds = menuItemIds;
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
