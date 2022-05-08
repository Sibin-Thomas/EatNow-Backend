package com.spe.eatnow_backend.controllers;

import com.spe.eatnow_backend.entities.User;
import com.spe.eatnow_backend.requestBodies.SearchRestaurantRequestBody;
import com.spe.eatnow_backend.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class SearchController {

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping(value = "/searchRestaurants")
    @CrossOrigin(origins = "*")
    public ArrayList<User> restaurantList(@RequestBody SearchRestaurantRequestBody searchRestaurantRequestBody)
    {
        ArrayList<User> restaurantList = restaurantService.findRestaurants(searchRestaurantRequestBody.getSearchValue());
        return restaurantList;
    }

}
