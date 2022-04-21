package com.spe.eatnow_backend.responseBodies;

import com.spe.eatnow_backend.entities.Orders;
import com.spe.eatnow_backend.entities.User;
import com.spe.eatnow_backend.helperClasses.OrderItem;
import com.spe.eatnow_backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class FetchOrderResponseBody {
    @Autowired
    private UserRepository userRepository;

    private List<OrderItem> orderItems;

    public FetchOrderResponseBody(User user) {
        orderItems = new ArrayList<>();
        for (Orders order: user.getUserOrders())
        {
            orderItems.add(new OrderItem(order.getorderId(), order.getStatus(), order.getTotal(), order.getRestaurant().getUsername()));
        }
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }
}
