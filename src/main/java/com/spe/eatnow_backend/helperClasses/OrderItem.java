package com.spe.eatnow_backend.helperClasses;

public class OrderItem {
    private Integer orderId;
    private String status;
    private Integer total;
    private String restaurantName;
    private String userName;
    private String userAddress;

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public OrderItem(Integer orderId, String status, Integer total, String restaurantName, String userName, String userAddress) {
        this.orderId = orderId;
        this.status = status;
        this.total = total;
        this.restaurantName = restaurantName;
        this.userName = userName;
        this.userAddress = userAddress;
    }

    public OrderItem(Integer orderId, String status, Integer total, String restaurantName) {
        this.orderId = orderId;
        this.status = status;
        this.total = total;
        this.restaurantName = restaurantName;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
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

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }
}
