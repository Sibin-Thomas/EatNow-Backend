package com.spe.eatnow_backend.controllers;

import com.spe.eatnow_backend.entities.Orders;
import com.spe.eatnow_backend.entities.User;
import com.spe.eatnow_backend.helperClasses.OrderItem;
import com.spe.eatnow_backend.repositories.UserRepository;
import com.spe.eatnow_backend.requestBodies.CommentRequestBody;
import com.spe.eatnow_backend.requestBodies.ImageRequestBody;
import com.spe.eatnow_backend.requestBodies.IsCustomerRequestBody;
import com.spe.eatnow_backend.requestBodies.UserRequestBody;
import com.spe.eatnow_backend.responseBodies.FetchOrderResponseBody;
import com.spe.eatnow_backend.responseBodies.RestaurantOrderHistoryResponseBody;
import com.spe.eatnow_backend.services.UserService;
import com.sun.tools.jconsole.JConsoleContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    private static final Logger logger= LogManager.getLogger(UserController.class);

    @PostMapping(value = "/addUser")
    @CrossOrigin(origins = "*")
    public String addUser(@RequestBody UserRequestBody userRequestBody)
    {
        String encodedPassword = Base64.getEncoder().encodeToString(userRequestBody.getPassword().getBytes());
        userRequestBody.setPassword(encodedPassword);
        userService.addUser(userRequestBody);
        return userRequestBody.getAddress();
    }
    
    @PostMapping(value = "/findUser")
    @CrossOrigin(origins = "*")
    public User findUser(@RequestBody UserRequestBody userRequestBody)
    {
        logger.info("[Find User] - Invoked");
        String encodedPassword = Base64.getEncoder().encodeToString(userRequestBody.getPassword().getBytes());
        userRequestBody.setPassword(encodedPassword);
        User user = userService.findUser(userRequestBody);
        return user;
    }

    @PostMapping(value = "/findUserById")
    @CrossOrigin(origins = "*")
    public User findUser1(@RequestBody UserRequestBody userRequestBody)
    {
	logger.info("[Find UserById] - Invoked");
	User user = userService.findUser(userRequestBody.getUser_id());
        System.out.println(user.getUsername());
        return user;
    }

    @PostMapping(value = "/fetchUserOrders")
    @CrossOrigin(origins = "*")
    public List<OrderItem> fetchUserOrders(@RequestBody UserRequestBody userRequestBody)
    {
	logger.info("[Find User Orders] - Invoked");
        User user = userService.findUser(userRequestBody.getUser_id());
        FetchOrderResponseBody fetchOrderResponseBody = new FetchOrderResponseBody(user);
        return fetchOrderResponseBody.getOrderItems();
//        return userService.findUser(userRequestBody.getUser_id()).getUserOrders();
    }

    @PostMapping(value = "/retaurantOrderHistory")
    @CrossOrigin(origins = "*")
    public List<OrderItem> restaurantOrderHistory(@RequestBody UserRequestBody userRequestBody)
    {
	logger.info("[Restaurant Order History] - Invoked");
        User user = userService.findUser(userRequestBody.getUser_id());
        ArrayList<String> acceptedStatuses = new ArrayList<>();
        if (userRequestBody.getOrderStatus().equals("pending"))
            acceptedStatuses.add("PENDING");
        else
        {
            acceptedStatuses.add("ACCEPTED");
            acceptedStatuses.add("REJECTED");
        }
        RestaurantOrderHistoryResponseBody restaurantOrderHistoryResponseBody = new RestaurantOrderHistoryResponseBody(user, acceptedStatuses);
        return restaurantOrderHistoryResponseBody.getOrderItemList();
    }

    @PostMapping(value = "/addComments")
    @CrossOrigin(origins = "*")
    public String addComments(@RequestBody CommentRequestBody commentRequestBody)
    {
	logger.info("[Add Comments] - Invoked");
        return userService.addComment(commentRequestBody);
    }

    @PostMapping(value = "/isCustomer")
    @CrossOrigin(origins = "*")
    public Boolean isCustomer(@RequestBody IsCustomerRequestBody isCustomerRequestBody)
    {
	logger.info("[Is Customer] - Invoked");
        return userService.isCustomer(isCustomerRequestBody);
    }

    @PostMapping(value = "/addImage")
    @CrossOrigin(origins = "*")
    public ArrayList<String> addImage(ImageRequestBody imageRequestBody) throws IOException
    {

        if (imageRequestBody.getRestaurantId() == imageRequestBody.getUserId() || isCustomer(new IsCustomerRequestBody(imageRequestBody.getUserId(), imageRequestBody.getRestaurantId())))
           return userService.addImage(imageRequestBody);
        return null;
    }

    @PostMapping(value = "/getImages")
    @CrossOrigin(origins = "*")
    public ArrayList<String> getImages(ImageRequestBody imageRequestBody) throws IOException
    {
        return userService.getImages(imageRequestBody);
    }
}
    