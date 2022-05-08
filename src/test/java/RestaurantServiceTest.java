import com.spe.eatnow_backend.entities.MenuItem;
import com.spe.eatnow_backend.entities.OrderItem;
import com.spe.eatnow_backend.entities.Orders;
import com.spe.eatnow_backend.entities.User;
import com.spe.eatnow_backend.repositories.*;
import com.spe.eatnow_backend.requestBodies.MenuItemRequestBody;
import com.spe.eatnow_backend.requestBodies.OrderRequestBody;
import com.spe.eatnow_backend.services.RestaurantService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.Optional;

public class RestaurantServiceTest {

    private RestaurantService restaurantService;

    private MenuItemRepository menuItemRepository;

    private UserRepository userRepository;

    private OrderRepository orderRepository;

    private OrderItemRepository orderItemRepository;

    private DiningItemRepository diningItemRepository;

    private CommentRepository commentRepository;

    @BeforeEach
    public void setup(){
        menuItemRepository= Mockito.mock(MenuItemRepository.class);
        userRepository= Mockito.mock(UserRepository.class);
        orderRepository= Mockito.mock(OrderRepository.class);
        orderItemRepository= Mockito.mock(OrderItemRepository.class);
        diningItemRepository= Mockito.mock(DiningItemRepository.class);
        commentRepository= Mockito.mock(CommentRepository.class);
        restaurantService=new RestaurantService();
        ReflectionTestUtils.setField(restaurantService,"menuItemRepository",menuItemRepository);
        ReflectionTestUtils.setField(restaurantService,"userRepository",userRepository);
        ReflectionTestUtils.setField(restaurantService,"orderRepository",orderRepository);
        ReflectionTestUtils.setField(restaurantService,"orderItemRepository",orderItemRepository);
        ReflectionTestUtils.setField(restaurantService,"diningItemRepository",diningItemRepository);
        ReflectionTestUtils.setField(restaurantService,"commentRepository",commentRepository);

    }

    @Test
    public void testAddMenuItem(){
        MenuItemRequestBody menuItemRequestBody=new MenuItemRequestBody();
        menuItemRequestBody.setRestaurant_id(123);
        menuItemRequestBody.setName("Truffles");
        menuItemRequestBody.setPrice(300);
        MenuItem menuItem = new MenuItem();
        Mockito.when(menuItemRepository.save(ArgumentMatchers.any(MenuItem.class)))
                .thenReturn(menuItem);
        restaurantService.addMenuItem(menuItemRequestBody);
    }

    @Test
    public void testFindRestaurants(){
        ArrayList<User> restaurantList=new ArrayList<>();
        User user=new User();
        user.setuserId(123);
        user.setType("Restaurant");
        restaurantList.add(user);
        Mockito.when(userRepository.findBySearchValue(ArgumentMatchers.anyString()))
                .thenReturn(restaurantList);
        restaurantService.findRestaurants("Truffles");
    }

    @Test
    public void testPlaceOrder(){
        OrderRequestBody orderRequestBody=new OrderRequestBody();
        ArrayList<Integer> menuIds=new ArrayList<>();
        menuIds.add(123);
        orderRequestBody.setuserId(123);
        orderRequestBody.setRestaurantId(123);
        orderRequestBody.setMenuItemIds(menuIds);
        orderRequestBody.setOrderId(133);
        orderRequestBody.setOrderTotal(500);
        User user=new User();
        Optional<User> optional=Optional.of(user);
        Mockito.when(userRepository.findById(ArgumentMatchers.anyInt()))
                .thenReturn(optional);
        ArrayList<Orders> orders=new ArrayList<>();
        Mockito.when(orderRepository.findByUser(ArgumentMatchers.any(User.class)))
                .thenReturn(orders);
        Orders orders1=new Orders();
        orders1.setorderId(123);
        Mockito.when(orderRepository.save(ArgumentMatchers.any(Orders.class)))
                .thenReturn(orders1);
        Mockito.when(orderRepository.findByUserAndOrderNumber(ArgumentMatchers.any(User.class),ArgumentMatchers.anyInt()))
                .thenReturn(orders1);
        OrderItem orderItem=new OrderItem();
        Mockito.when(orderItemRepository.save(ArgumentMatchers.any(OrderItem.class)))
                .thenReturn(orderItem);
        restaurantService.placeOrder(orderRequestBody);
    }

    @Test
    public void testUpdateOrderStatus(){
        OrderRequestBody orderRequestBody=new OrderRequestBody();
        orderRequestBody.setOrderId(124);
        orderRequestBody.setStatus("DOne");
        Orders order=new Orders();
        Mockito.when(orderRepository.save(ArgumentMatchers.any(Orders.class)))
                .thenReturn(order);
        Mockito.when(orderRepository.findByOrderId(ArgumentMatchers.anyInt()))
                .thenReturn(order);
        restaurantService.updateOrderStatus(orderRequestBody);
    }
}
