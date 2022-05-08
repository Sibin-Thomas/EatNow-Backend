package com.spe.eatnow_backend.repositories;

import com.spe.eatnow_backend.entities.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {
    ArrayList<Comment> findByRestaurantId(Integer restaurantId);

    @Query(value = "select sum(rating)/count(commentId) from Comment group by restaurantId having restaurantId = ?1")
    Integer findRating(Integer restaurantId);
}
