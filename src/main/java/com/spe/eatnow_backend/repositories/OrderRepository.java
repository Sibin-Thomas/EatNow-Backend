package com.spe.eatnow_backend.repositories;

import com.spe.eatnow_backend.entities.Orders;
import com.spe.eatnow_backend.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface OrderRepository extends CrudRepository<Orders, Integer> {
    ArrayList<Orders> findByUser(User user);
    Orders findByUserAndOrderNumber(User user, Integer orderNumber);
}
