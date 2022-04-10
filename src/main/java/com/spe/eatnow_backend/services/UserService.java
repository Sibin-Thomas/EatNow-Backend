package com.spe.eatnow_backend.services;

import com.spe.eatnow_backend.entities.User;
import com.spe.eatnow_backend.repositories.UserRepository;
import com.spe.eatnow_backend.requestBodies.UserRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void addUser(UserRequestBody userRequestBody)
    {
        User user = new User();
        user.setUsername(userRequestBody.getUsername());
        user.setPassword(userRequestBody.getPassword());
        user.setEmail(userRequestBody.getEmail());
        user.setPhone(userRequestBody.getPhone());
        user.setType(userRequestBody.getType());
        user.setAddress(userRequestBody.getAddress());
        user.setUser_id(22);
        System.out.println(userRequestBody.getAddress());
        userRepository.save(user);
    }

    public User findUser(UserRequestBody user)
    {

        return userRepository.findByUsernameAndPasswordAndType(user.getUsername(), user.getPassword(), user.getType());
    }

    public User findUser(Integer user_id)
    {
        return userRepository.findById(user_id).orElse(new User());
    }

}
