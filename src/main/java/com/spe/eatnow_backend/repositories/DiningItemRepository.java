package com.spe.eatnow_backend.repositories;

import com.spe.eatnow_backend.entities.DiningItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface DiningItemRepository extends CrudRepository<DiningItem, Integer> {
    ArrayList<DiningItem> findByRestaurantId(Integer restaurantId);
}
