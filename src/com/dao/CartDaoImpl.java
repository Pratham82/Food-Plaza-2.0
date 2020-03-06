package com.dao;
import com.pojo.Cart;
import com.utility.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CartDaoImpl implements CartDao{
    Connection con  = DBConnection.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    int result;
    String sql;
    Cart c = null;

    @Override
    public boolean AddToCart(Cart c) {
        try{
            sql = "insert into cart(foodid, customeremail,quantity) values (?, ?, ?) ";
            ps = con.prepareStatement(sql);
            ps.setInt(1,c.getFoodID());
            ps.setString(2,c.getCustomerEmail());
            ps.setInt(3,c.getQuantity());
            result = ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }

        if(result>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean UpdateCart(Cart c) {
        try{
            sql = "update cart set foodid =?, customeremail =?, quantity =? where cartid =?";
            ps = con.prepareStatement(sql);
            ps.setInt(1,c.getFoodID());
            ps.setString(2,c.getCustomerEmail());
            ps.setInt(3,c.getQuantity());
            ps.setInt(4,c.getCartID());
            result = ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }

        if(result>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean DeleteFromCartByCartID(int CartID) {
        try{
            sql="delete from cart where cartid =?";
            ps = con.prepareStatement(sql);
            ps.setInt(1,CartID);
            result = ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        if(result>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean DeleteFromCartByCustomerEmail(String CustomerEmail) {
        try{
            sql="delete from cart where customerEmail =?";
            ps = con.prepareStatement(sql);
            ps.setString(1,CustomerEmail);
            result = ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        if(result>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<Cart> ShowAllItems() {
        List<Cart> list1 = new ArrayList<>();
        try{
            sql ="select c.cartid,f.foodid,f.foodname,f.foodcategory,f.foodprice, c.customeremail,c.quantity from food f inner join cart c on f.foodid = c.foodid";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                c = new Cart();
                c.setCartID(rs.getInt(1));
                c.setFoodID(rs.getInt(2));
                c.setFoodName(rs.getString(3));
                c.setFoodCategory(rs.getString(4));
                c.setFoodPrice(rs.getDouble(5));
                c.setCustomerEmail(rs.getString(6));
                c.setQuantity(rs.getInt(7));
                list1.add(c);
            }
            return list1;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Cart SearchFromCartByID(int CarID) {
        return null;
    }

    @Override
    public Cart SearchFromCartByCustomerEmail(String CustomerEmail) {
        return null;
    }
}
