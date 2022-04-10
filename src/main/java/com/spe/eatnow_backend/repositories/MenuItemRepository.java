package com.spe.eatnow_backend.repositories;

import com.spe.eatnow_backend.entities.MenuItem;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface MenuItemRepository extends CrudRepository<MenuItem, Integer> {
    ArrayList<MenuItem> findByRestaurantId(Integer restaurantId);
}
