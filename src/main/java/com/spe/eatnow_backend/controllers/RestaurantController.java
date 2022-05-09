package com.spe.eatnow_backend.controllers;

import com.spe.eatnow_backend.entities.*;
import com.spe.eatnow_backend.helperClasses.OrderItem;
import com.spe.eatnow_backend.requestBodies.*;
import com.spe.eatnow_backend.responseBodies.BookingHistoryResponseBody;
import com.spe.eatnow_backend.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    private static final Logger logger= LogManager.getLogger(RestaurantController.class);
    @PostMapping(value = "/addMenuItem")
    @CrossOrigin(origins = "*")
    public String addMenuItem(@RequestBody MenuItemRequestBody menuItemRequestBody)
    {
	logger.info("[Add Menu Item] - Invoked");
        return restaurantService.addMenuItem(menuItemRequestBody);
    }

    @PostMapping(value = "/findMenuItems")
    @CrossOrigin(origins = "*")
    public ArrayList<MenuItem> findMenuItems(@RequestBody MenuItemRequestBody menuItemRequestBody)
    {
	logger.info("[Find Menu Items] - Invoked");
        return restaurantService.findByRestaurantId(menuItemRequestBody.getRestaurant_id());
    }

    @PostMapping(value = "/placeOrder")
    @CrossOrigin(origins = "*")
    public String placeOrder(@RequestBody OrderRequestBody orderRequestBody)
    {
	logger.info("[Place Order] - Invoked");
        return restaurantService.placeOrder(orderRequestBody);
    }

    @PostMapping(value = "/updateOrderStatus")
    @CrossOrigin(origins = "*")
    public String updateOrderStatus(@RequestBody OrderRequestBody orderRequestBody)
    {
	logger.info("[Update Order Status] - Invoked");
        return restaurantService.updateOrderStatus(orderRequestBody);
    }

    @PostMapping(value = "/addDiningItem")
    @CrossOrigin(origins = "*")
    public String addDiningItem(@RequestBody DiningItemRequestBody diningItemRequestBody)
    {
	logger.info("[Add Dining Item] - Invoked");
        return restaurantService.addDiningItem(diningItemRequestBody);
    }

    @PostMapping(value = "/findComments")
    @CrossOrigin(origins = "*")
    public ArrayList<Comment> findComments(@RequestBody CommentRequestBody commentRequestBody)
    {
	logger.info("[Find Comments] - Invoked");
        return restaurantService.findComments(commentRequestBody);
    }

    @PostMapping(value = "/updateCapacity")
    @CrossOrigin(origins = "*")
    public String updateCapacity(@RequestBody DiningCapacityRequestBody diningCapacityRequestBody)
    {
	logger.info("[Update Capacity] - Invoked");
        return restaurantService.updateCapacity(diningCapacityRequestBody);
    }

    @PostMapping(value = "/bookTable")
    @CrossOrigin(origins = "*")
    public String bookTable(@RequestBody BookingRequestBody bookingRequestBody)
    {
	logger.info("[Book Table] - Invoked");
        return restaurantService.bookTable(bookingRequestBody);
    }

    @PostMapping(value = "/getBookingHistory")
    @CrossOrigin(origins = "*")
    public ArrayList<BookingHistoryResponseBody> getBookingHistory(@RequestBody BookingRequestBody bookingRequestBody)
    {
	logger.info("[Get Booking History] - Invoked");
        return restaurantService.getBookingHistory(bookingRequestBody);
    }
}
