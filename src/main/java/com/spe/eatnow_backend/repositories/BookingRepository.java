package com.spe.eatnow_backend.repositories;

import com.spe.eatnow_backend.entities.Booking;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Integer> {
    @Query(value = "select count(datetime) from booking group by restaurant_id, datetime having restaurant_id = ?1 and datetime = ?2", nativeQuery = true)
    Integer findBookingCount(Integer restaurantId, String datetime);

    ArrayList<Booking> findByUserId(Integer userId);
    ArrayList<Booking> findByRestaurantId(Integer restaurantId);
}
