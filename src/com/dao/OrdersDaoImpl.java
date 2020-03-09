package com.dao;

import com.pojo.Orders;
import com.utility.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class OrdersDaoImpl implements OrdersDao{
    Connection con  = DBConnection.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    int result;
    String SQL;

    //Variables from Orders which we have to generate
    double TotalPrice;
    String OrderDate;

    //Orders class reference
    Orders  o = null;

    @Override
    public Orders PlaceOrders(String CustomerEmail) {
        //Getting current date and time
        Date d = new Date();
        OrderDate = d.toString();

        try {
            //Query for total price
            SQL = "select sum(f.foodprice *c.quantity) from cart c inner join food f on f.foodid = c.foodid where customeremail =? ";
            ps = con.prepareStatement(SQL);
            ps.setString(1,CustomerEmail);
            rs = ps.executeQuery();

            //getting total price
            while(rs.next()){
                TotalPrice = rs.getDouble(1);
            }

            //Inserting values in orders table
            SQL ="insert into orders(totalprice,customeremail,orderstatus,orderdate) values(?,?,?,?)";
            ps = con.prepareStatement(SQL);
            ps.setDouble(1,TotalPrice);
            ps.setString(2,CustomerEmail);
            ps.setString(3,"Processing");
            ps.setString(4,OrderDate);

            result = ps.executeUpdate();

            //Delete that item from the cart which was ordered by the entered customer email
            new CartDaoImpl().DeleteFromCartByCustomerEmail(CustomerEmail);

            //Showing placed order
            SQL = "select * from orders";
            ps = con.prepareStatement(SQL);
            rs = ps.executeQuery();

            while(rs.next()){
                o = new Orders();
                o.setOrderID(rs.getInt(1));
                o.setTotalPrice(rs.getDouble(2));
                o.setCustomerEmail(rs.getString(3));
                o.setOrderStatus(rs.getString(4));
                o.setOrderDate(rs.getString(5));

                return o;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Orders> ShowAllOrders() {
        List<Orders> list1= new ArrayList<>();
        try {
            SQL ="select * from orders";
            ps = con.prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){
                o = new Orders();
                o.setOrderID(rs.getInt(1));
                o.setTotalPrice(rs.getDouble(2));
                o.setCustomerEmail(rs.getString(3));
                o.setOrderStatus(rs.getString(4));
                o.setOrderDate(rs.getString(5));
                list1.add(o);
            }
            return list1;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Orders> ShowMyOrder(String CustomerEmail) {
        List<Orders> list2= new ArrayList<>();
        try {
            SQL ="select * from orders where customeremail =?";
            ps = con.prepareStatement(SQL);
            ps.setString(1,CustomerEmail);
            rs = ps.executeQuery();
            while(rs.next()){
                o = new Orders();
                o.setOrderID(rs.getInt(1));
                o.setTotalPrice(rs.getDouble(2));
                o.setCustomerEmail(rs.getString(3));
                o.setOrderStatus(rs.getString(4));
                o.setOrderDate(rs.getString(5));
                list2.add(o);
            }
            return list2;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
