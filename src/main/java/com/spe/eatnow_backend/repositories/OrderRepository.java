package com.spe.eatnow_backend.repositories;

import com.spe.eatnow_backend.entities.Orders;
import com.spe.eatnow_backend.entities.User;
import org.hibernate.criterion.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface OrderRepository extends CrudRepository<Orders, Integer> {
    ArrayList<Orders> findByUser(User user);
    Orders findByUserAndOrderNumber(User user, Integer orderNumber);
    Orders findByUserAndStatus(User user, String status);
    ArrayList<Orders> findByRestaurantAndStatus(User restaurant, String status);
    Orders findByOrderId(Integer orderId);
    ArrayList<Orders> findByUserAndRestaurant(User user, User restaurant);
}
