package com.spe.eatnow_backend.repositories;

import com.spe.eatnow_backend.entities.Orders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface OrderRepository extends CrudRepository<Orders, Integer> {
    ArrayList<Orders> findByUserId(Integer userId);
    Orders findByUserIdAndOrderNumber(Integer userId, Integer orderNumber);
}
