package com.spe.eatnow_backend.entities;b

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int userId;

    private String username;

    private String password;

    private String type;

    private String address;

    private String phone;

    private String email;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public User() {
    }

    @OneToMany(mappedBy = "user")
    @PrimaryKeyJoinColumn
    private List<Orders> userOrders;

    @OneToMany(mappedBy = "restaurant")
    @PrimaryKeyJoinColumn
    private List<Orders> restaurantOrders;

    @JsonManagedReference
    public List<Orders> getUserOrders() {
        return userOrders;
    }

    @JsonManagedReference
    public List<Orders> getRestaurantOrders() {
        return restaurantOrders;
    }

    public User(String username, String password, String type, String address, String phone, String email) {
        this.username = username;
        this.password = password;
        this.type = type;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public int getuserId() {
        return userId;
    }

    public void setuserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
