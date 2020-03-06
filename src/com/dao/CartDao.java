package com.dao;

import com.pojo.Cart;

import java.util.List;

public interface CartDao {
    boolean AddToCart(Cart c);
    boolean UpdateCart(Cart c);
    boolean DeleteFromCartByCartID(int CartID);
    boolean DeleteFromCartByCustomerEmail(String CustomerEmail);

    List<Cart> ShowAllItems();
    Cart SearchFromCartByID(int CarID);
    Cart SearchFromCartByCustomerEmail(String CustomerEmail);
}
