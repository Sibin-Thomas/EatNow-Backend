package com.spe.eatnow_backend.entities;

import javax.persistence.*;

@Entity
@Table(name = "dining_capacity")
public class DiningCapacity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer diningCapacityId;

    private Integer restaurantId;

    private Integer capacity;

    public DiningCapacity() {
    }

    public DiningCapacity(Integer diningCapacityId, Integer restaurantId, Integer capacity) {
        this.diningCapacityId = diningCapacityId;
        this.restaurantId = restaurantId;
        this.capacity = capacity;
    }

    public Integer getDiningCapacityId() {
        return diningCapacityId;
    }

    public void setDiningCapacityId(Integer diningCapacityId) {
        this.diningCapacityId = diningCapacityId;
    }

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
}