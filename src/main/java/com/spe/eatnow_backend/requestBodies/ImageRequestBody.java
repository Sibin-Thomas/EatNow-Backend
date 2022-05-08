package com.spe.eatnow_backend.requestBodies;b

import org.springframework.web.multipart.MultipartFile;

public class ImageRequestBody {
    MultipartFile image;
    Integer userId;
    Integer restaurantId;

    public ImageRequestBody() {
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }
}
