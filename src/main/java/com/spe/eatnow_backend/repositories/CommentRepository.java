package com.spe.eatnow_backend.repositories;b

import com.spe.eatnow_backend.entities.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {
    ArrayList<Comment> findByRestaurantId(Integer restaurantId);
}
