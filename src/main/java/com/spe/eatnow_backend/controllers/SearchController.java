package com.spe.eatnow_backend.controllers;

import com.spe.eatnow_backend.entities.User;
import com.spe.eatnow_backend.requestBodies.SearchRestaurantRequestBody;
import com.spe.eatnow_backend.services.RestaurantService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class SearchController {

    @Autowired
    private RestaurantService restaurantService;

    private static final Logger logger= LogManager.getLogger(SearchController.class);

    @PostMapping(value = "/searchRestaurants")
    @CrossOrigin(origins = "*")
    public ArrayList<User> restaurantList(@RequestBody SearchRestaurantRequestBody searchRestaurantRequestBody)
    {
        logger.info("[Search Restaurants] - Invoked");
        ArrayList<User> restaurantList = restaurantService.findRestaurants(searchRestaurantRequestBody.getSearchValue());
        return restaurantList;
    }

}
