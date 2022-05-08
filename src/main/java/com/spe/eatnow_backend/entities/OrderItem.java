package com.spe.eatnow_backend.entities;b

import javax.persistence.*;

@Entity
@Table(name = "order_item")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderItemId;

    private Integer orderId;

    private Integer menuId;

    public Integer getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Integer orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public OrderItem() {
    }

    public OrderItem(Integer orderId, Integer menuId) {
        this.orderItemId = orderItemId;
        this.orderId = orderId;
        this.menuId = menuId;
    }
}
