package com.spe.eatnow_backend.controllers;

import com.spe.eatnow_backend.entities.MenuItem;
import com.spe.eatnow_backend.entities.User;
import com.spe.eatnow_backend.requestBodies.MenuItemRequestBody;
import com.spe.eatnow_backend.requestBodies.UserRequestBody;
import com.spe.eatnow_backend.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping(value = "/addMenuItem")
    @CrossOrigin(origins = "*")
    public String addMenuItem(@RequestBody MenuItemRequestBody menuItemRequestBody)
    {
        return restaurantService.addMenuItem(menuItemRequestBody);
    }

    @PostMapping(value = "/findMenuItems")
    @CrossOrigin(origins = "*")
    public ArrayList<MenuItem> findMenuItems(@RequestBody MenuItemRequestBody menuItemRequestBody)
    {
        return restaurantService.findByRestaurantId(menuItemRequestBody.getRestaurant_id());
    }

}
