package com.dao;

import com.pojo.Orders;

import java.util.List;

public interface OrdersDao {
    Orders PlaceOrders(String CustomerEmail);
    List<Orders> ShowAllOrders();
    List<Orders> ShowMyOrder(String CustomerEmail);
}
