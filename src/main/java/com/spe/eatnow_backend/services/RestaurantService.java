package com.spe.eatnow_backend.services;

import com.spe.eatnow_backend.entities.*;
import com.spe.eatnow_backend.entities.MenuItem;
import com.spe.eatnow_backend.repositories.*;
import com.spe.eatnow_backend.requestBodies.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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
    @Autowired
    private DiningItemRepository diningItemRepository;
    @Autowired
    private CommentRepository commentRepository;

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
        User user = userRepository.findById(orderRequestBody.getuserId()).get();
        ArrayList<Orders> orders = orderRepository.findByUser(user);
        Integer orderNumber = orders.size()+1;
        Orders order = new Orders("PENDING", orderNumber, user, userRepository.findById(orderRequestBody.getRestaurantId()).get(), orderRequestBody.getOrderTotal());
        orderRepository.save(order);
        order = orderRepository.findByUserAndOrderNumber(user, orderNumber);
        for (Integer menuId: orderRequestBody.getMenuItemIds())
        {
            orderItemRepository.save(new OrderItem(order.getorderId(), menuId));
        }
        return "success";
    }

    public String updateOrderStatus(OrderRequestBody orderRequestBody)
    {
        Orders order = orderRepository.findByOrderId(orderRequestBody.getOrderId());
        order.setStatus(orderRequestBody.getStatus());
        orderRepository.save(order);
        return "success";
    }

    public String addDiningItem(DiningItemRequestBody diningItemRequestBody)
    {
        diningItemRepository.save(new DiningItem(diningItemRequestBody.getSlot(), diningItemRequestBody.getRestaurantId(), diningItemRequestBody.getPrice()));
        return "success";
    }

    public ArrayList<DiningItem> findDiningItemsByRestaurantId(DiningItemRequestBody diningItemRequestBody)
    {
        return diningItemRepository.findByRestaurantId(diningItemRequestBody.getRestaurantId());
    }

    public ArrayList<Comment> findComments(CommentRequestBody commentRequestBody)
    {
        System.out.println(commentRequestBody.toString());
        return commentRepository.findByRestaurantId(commentRequestBody.getRestaurantId());
    }
}