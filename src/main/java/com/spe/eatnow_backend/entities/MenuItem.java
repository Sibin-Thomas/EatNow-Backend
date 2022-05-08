package com.spe.eatnow_backend.entities;

import javax.persistence.*;

@Entity
@Table(name = "menu_item")
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer menu_item_id;

    public String name;

    public Integer price;

    public Integer restaurantId;

    public MenuItem(Integer menu_item_id, String name, Integer price, Integer restaurantId) {
        this.menu_item_id = menu_item_id;
        this.name = name;
        this.price = price;
        this.restaurantId = restaurantId;
    }

    public Integer getrestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Integer getMenu_item_id() {
        return menu_item_id;
    }

    public void setMenu_item_id(Integer menu_item_id) {
        this.menu_item_id = menu_item_id;
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

    public MenuItem() {
    }
}
