package com.spe.eatnow_backend.entities;

import javax.persistence.*;

@Entity
@Table(name = "dining_item")
public class DiningItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer diningId;

    public String slot;

    public Integer price;

    public Integer restaurantId;

    public DiningItem() {
    }

    public DiningItem(String slot, Integer price, Integer restaurantId) {
        this.slot = slot;
        this.price = price;
        this.restaurantId = restaurantId;
    }

    public Integer getDiningId() {
        return diningId;
    }

    public void setDiningId(Integer diningId) {
        this.diningId = diningId;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }
}
