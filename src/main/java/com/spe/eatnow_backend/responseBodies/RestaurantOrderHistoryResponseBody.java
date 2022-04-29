package com.spe.eatnow_backend.responseBodies;

import com.spe.eatnow_backend.entities.Orders;
import com.spe.eatnow_backend.entities.User;
import com.spe.eatnow_backend.helperClasses.OrderItem;
import com.spe.eatnow_backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class RestaurantOrderHistoryResponseBody {

    @Autowired
    private UserRepository userRepository;

    private List<OrderItem> orderItemList;

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public RestaurantOrderHistoryResponseBody(User user, ArrayList<String> acceptedStatus)
    {
        orderItemList = new ArrayList<>();
        for (Orders order: user.getRestaurantOrders())
        {
            if (acceptedStatus.contains(order.getStatus()))
                orderItemList.add(new OrderItem(order.getorderId(), order.getStatus(), order.getTotal(), order.getRestaurant().getUsername(), order.getUser().getUsername(), order.getUser().getAddress()));
        }
    }

}
