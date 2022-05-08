package com.spe.eatnow_backend.repositories;

import com.spe.eatnow_backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsernameAndPasswordAndType(String username, String password, String type);
    ArrayList<User> findByType(String type);
    User findByUserId(Integer userid);

    @Query(value = "select * from user where username like %?1%", nativeQuery = true)
    ArrayList<User> findBySearchValue(String searchValue);

}
