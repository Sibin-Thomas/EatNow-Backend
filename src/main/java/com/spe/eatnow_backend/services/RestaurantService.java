package com.spe.eatnow_backend.services;

import com.spe.eatnow_backend.entities.MenuItem;
import com.spe.eatnow_backend.repositories.MenuItemRepository;
import com.spe.eatnow_backend.requestBodies.MenuItemRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;

@Service
public class RestaurantService {
    @Autowired
    private MenuItemRepository menuItemRepository;

    public String addMenuItem(MenuItemRequestBody menuItemRequestBody)
    {
        MenuItem menuItem = new MenuItem();
        menuItem.setRestaurantId(menuItemRequestBody.getRestaurant_id());
        menuItem.setName(menuItemRequestBody.getName());
        menuItem.setPrice(menuItemRequestBody.getPrice());
        menuItemRepository.save(menuItem);
        return "success";
    }

    public ArrayList<MenuItem> findByRestaurantId(Integer restaurantId)
    {
        return menuItemRepository.findByRestaurantId(restaurantId);
    }
}
