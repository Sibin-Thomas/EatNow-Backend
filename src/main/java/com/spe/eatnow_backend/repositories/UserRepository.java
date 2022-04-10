package com.spe.eatnow_backend.repositories;

import com.spe.eatnow_backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsernameAndPasswordAndType(String username, String password, String type);
}
