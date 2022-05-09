package com.spe.eatnow_backend.responseBodies;

public class BookingHistoryResponseBody {
    private String time;
    private String restaurantName;

    public BookingHistoryResponseBody() {
    }

    public BookingHistoryResponseBody(String time, String restaurantName) {
        this.time = time;
        this.restaurantName = restaurantName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }
}
