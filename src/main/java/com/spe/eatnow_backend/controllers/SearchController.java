package com.spe.eatnow_backend.controllers;

import com.spe.eatnow_backend.requestBodies.SearchRestaurantRequestBody;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class SearchController {

    @PostMapping(value = "/searchRestaurants")
    @CrossOrigin(origins = "*")
    public ArrayList<ArrayList<String>> restaurantList(@RequestBody SearchRestaurantRequestBody searchRestaurantRequestBody)
    {
        System.out.println(searchRestaurantRequestBody.getSearchValue());
        ArrayList<ArrayList<String>> restaurantList = new ArrayList<ArrayList<String>>();
        ArrayList<String> restaurant = new ArrayList<>();
        restaurant.add("Truffles");
        restaurant.add("5");
        restaurant.add("Adiglide Tower, Electronic City Phase I, Bangalore");
        restaurant.add("true");
        restaurant.add("1");
        restaurantList.add(restaurant);
        ArrayList<String> restaurant1 = new ArrayList<>();
        restaurant1.add("ddddd");
        restaurant1.add("5");
        restaurant1.add("Adiglide Tower, Electronic City Phase I, Bangalore");
        restaurant1.add("true");
        restaurant1 .add("2");
        restaurantList.add(restaurant1);
        return restaurantList;
    }

}
