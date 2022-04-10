package com.spe.eatnow_backend.controllers;

import com.spe.eatnow_backend.entities.User;
import com.spe.eatnow_backend.requestBodies.UserRequestBody;
import com.spe.eatnow_backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/addUser")
    @CrossOrigin(origins = "*")
    public String addUser(@RequestBody UserRequestBody userRequestBody)
    {
        userService.addUser(userRequestBody);
        return userRequestBody.getAddress();
    }
    
    @PostMapping(value = "/findUser")
    @CrossOrigin(origins = "*")
    public User findUser(@RequestBody UserRequestBody userRequestBody)
    {
        User user = userService.findUser(userRequestBody);
        System.out.println(user.getUsername());
        return user;
    }

    @PostMapping(value = "/findUserById")
    @CrossOrigin(origins = "*")
    public User findUser1(@RequestBody UserRequestBody userRequestBody)
    {
        User user = userService.findUser(userRequestBody.getUser_id());
        System.out.println(user.getUsername());
        return user;
    }


}
