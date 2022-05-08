package com.spe.eatnow_backend.services;b

import com.spe.eatnow_backend.entities.Comment;
import com.spe.eatnow_backend.entities.Orders;
import com.spe.eatnow_backend.entities.User;
import com.spe.eatnow_backend.repositories.CommentRepository;
import com.spe.eatnow_backend.repositories.OrderRepository;
import com.spe.eatnow_backend.repositories.UserRepository;
import com.spe.eatnow_backend.requestBodies.CommentRequestBody;
import com.spe.eatnow_backend.requestBodies.ImageRequestBody;
import com.spe.eatnow_backend.requestBodies.IsCustomerRequestBody;
import com.spe.eatnow_backend.requestBodies.UserRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private OrderRepository orderRepository;

    public void addUser(UserRequestBody userRequestBody)
    {
        User user = new User(userRequestBody.getUsername(), userRequestBody.getPassword(), userRequestBody.getType(), userRequestBody.getAddress(), userRequestBody.getPhone(), userRequestBody.getEmail());
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

    public String addComment(CommentRequestBody commentRequestBody)
    {
        ArrayList<Orders> order = orderRepository.findByUserAndRestaurant(userRepository.findByUserId(commentRequestBody.getUserId()), userRepository.findByUserId(commentRequestBody.getRestaurantId()));
        if (order.size() != 0) {
            commentRepository.save(new Comment(commentRequestBody.getUserId(), commentRequestBody.getRestaurantId(), commentRequestBody.getRating(), commentRequestBody.getComment()));
            return "success";
        }
        return "failed";
    }

    public Boolean isCustomer(IsCustomerRequestBody isCustomerRequestBody)
    {
        ArrayList<Orders> orders = orderRepository.findByUserAndRestaurant(userRepository.findByUserId(isCustomerRequestBody.getUserId()), userRepository.findByUserId(isCustomerRequestBody.getRestaurantId()));
        if (orders.size() == 0)
            return false;
        return true;
    }

    public ArrayList<String> addImage(ImageRequestBody imageRequestBody) throws IOException {
        String fileName = imageRequestBody.getImage().getOriginalFilename();
        String uploadDirectoryName = "./src/main/resources/static/"+imageRequestBody.getRestaurantId();
        Path uploadPath = Paths.get(uploadDirectoryName);
        if (!Files.exists(uploadPath))
            Files.createDirectories(uploadPath);
        try (InputStream inputStream = imageRequestBody.getImage().getInputStream())
        {
            Path filePath = uploadPath.resolve(fileName);
            System.out.println(filePath.toString());
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        }
        catch (IOException e)
        {
            return null;
        }
        return getImages(imageRequestBody);
    }

    public ArrayList<String> getImages(ImageRequestBody imageRequestBody)
    {
        File folder = new File("./src/main/resources/static/"+imageRequestBody.getRestaurantId());
        System.out.println(folder.getPath());
        File[] files = folder.listFiles();
        ArrayList<String> paths = new ArrayList<>();
        for (File file: files)
        {
            paths.add("/resources/" + imageRequestBody.getRestaurantId() +"/"+ file.getName());
        }
        return paths;
    }

}
