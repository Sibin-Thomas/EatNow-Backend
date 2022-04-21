package com.spe.eatnow_backend.controllers;

import com.spe.eatnow_backend.entities.Orders;
import com.spe.eatnow_backend.entities.User;
import com.spe.eatnow_backend.helperClasses.OrderItem;
import com.spe.eatnow_backend.repositories.UserRepository;
import com.spe.eatnow_backend.requestBodies.UserRequestBody;
import com.spe.eatnow_backend.responseBodies.FetchOrderResponseBody;
import com.spe.eatnow_backend.services.UserService;
import com.sun.tools.jconsole.JConsoleContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        System.out.println(userRequestBody.getUsername()+userRequestBody.getPassword()+userRequestBody.getType());
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

    @PostMapping(value = "/fetchUserOrders")
    @CrossOrigin(origins = "*")
    public List<OrderItem> fetchUserOrders(@RequestBody UserRequestBody userRequestBody)
    {
        User user = userService.findUser(userRequestBody.getUser_id());
        FetchOrderResponseBody fetchOrderResponseBody = new FetchOrderResponseBody(user);
        return fetchOrderResponseBody.getOrderItems();
//        return userService.findUser(userRequestBody.getUser_id()).getUserOrders();
    }
}
