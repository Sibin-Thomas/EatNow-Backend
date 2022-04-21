package com.spe.eatnow_backend.services;

import com.spe.eatnow_backend.entities.MenuItem;
import com.spe.eatnow_backend.entities.OrderItem;
import com.spe.eatnow_backend.entities.Orders;
import com.spe.eatnow_backend.entities.User;
import com.spe.eatnow_backend.repositories.MenuItemRepository;
import com.spe.eatnow_backend.repositories.OrderItemRepository;
import com.spe.eatnow_backend.repositories.OrderRepository;
import com.spe.eatnow_backend.repositories.UserRepository;
import com.spe.eatnow_backend.requestBodies.MenuItemRequestBody;
import com.spe.eatnow_backend.requestBodies.OrderRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;

@Service
public class RestaurantService {
    @Autowired
    private MenuItemRepository menuItemRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;

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

    public ArrayList<User> findRestaurants(String searchValue)
    {
        ArrayList<User> restaurantList = userRepository.findByType("Restaurant");
        return restaurantList;
    }

    public String placeOrder(OrderRequestBody orderRequestBody)
    {
        ArrayList<Orders> orders = orderRepository.findByUser(userRepository.findById(orderRequestBody.getuserId()).get());
        Integer orderNumber = orders.size()+1;
        Orders order = new Orders();
        order.setOrderNumber(orderNumber);
        order.setUser(userRepository.findById(orderRequestBody.getuserId()).get());
        order.setRestaurant(userRepository.findById(orderRequestBody.getRestaurantId()).get());
//        order.setUserId(orderRequestBody.getuserId());
        order.setStatus("PENDING");
        order.setTotal(orderRequestBody.getOrderTotal());
//        order.setRestaurantId(orderRequestBody.getRestaurantId());
        orderRepository.save(order);

        order = orderRepository.findByUserAndOrderNumber(userRepository.findById(orderRequestBody.getuserId()).get(), orderNumber);
        for (Integer menuId: orderRequestBody.getMenuItemIds())
        {
            orderItemRepository.save(new OrderItem(order.getorderId(), menuId));
        }
        return "success";
    }

}
