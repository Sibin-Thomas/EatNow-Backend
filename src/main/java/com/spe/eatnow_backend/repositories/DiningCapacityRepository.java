package com.spe.eatnow_backend.repositories;

import com.spe.eatnow_backend.entities.DiningCapacity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiningCapacityRepository extends CrudRepository<DiningCapacity, Integer> {
    DiningCapacity findByRestaurantId(Integer restaurantId);
}
