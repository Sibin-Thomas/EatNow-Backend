package com.spe.eatnow_backend.controllers;b

import com.spe.eatnow_backend.entities.Comment;
import com.spe.eatnow_backend.entities.MenuItem;
import com.spe.eatnow_backend.entities.Orders;
import com.spe.eatnow_backend.entities.User;
import com.spe.eatnow_backend.helperClasses.OrderItem;
import com.spe.eatnow_backend.requestBodies.*;
import com.spe.eatnow_backend.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    @PostMapping(value = "/placeOrder")
    @CrossOrigin(origins = "*")
    public String placeOrder(@RequestBody OrderRequestBody orderRequestBody)
    {
        return restaurantService.placeOrder(orderRequestBody);
    }

    @PostMapping(value = "/updateOrderStatus")
    @CrossOrigin(origins = "*")
    public String updateOrderStatus(@RequestBody OrderRequestBody orderRequestBody)
    {
        return restaurantService.updateOrderStatus(orderRequestBody);
    }

    @PostMapping(value = "/addDiningItem")
    @CrossOrigin(origins = "*")
    public String addDiningItem(@RequestBody DiningItemRequestBody diningItemRequestBody)
    {
        return restaurantService.addDiningItem(diningItemRequestBody);
    }

    @PostMapping(value = "/findComments")
    @CrossOrigin(origins = "*")
    public ArrayList<Comment> addDiningItem(@RequestBody CommentRequestBody commentRequestBody)
    {
        return restaurantService.findComments(commentRequestBody);
    }

}
