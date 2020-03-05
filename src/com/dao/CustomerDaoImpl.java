package com.dao;

import com.pojo.Customer;
import com.utility.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao{
    Connection con = DBConnection.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    int result;
    String SQL ;

    //References from Customer class
    Customer CustomerObj = null;
    //Customer c = null;
    @Override
    public boolean AddCustomer(Customer c) {
        try{
            SQL = "insert into Customer(customername,customeremail,customerpass,customercontact,customeradd) values(?,?,?,?,?)";
            ps = con.prepareStatement(SQL);

            ps.setString(1,c.getCustomerName());
            ps.setString(2,c.getCustomerEmail());
            ps.setString(3,c.getCustomerPass());
            ps.setString(4,c.getCustomerContact());
            ps.setString(5,c.getCustomerAdd());
            result = ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }

        if(result > 0) {
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean UpdateCustomer(Customer c) {
        try{
            SQL = "update customer set customername =?, customeremail =?, customerpass =?, customercontact =?, customeradd =? where customerid =?";
            ps = con.prepareStatement(SQL);

            ps.setString(1,c.getCustomerName());
            ps.setString(2,c.getCustomerEmail());
            ps.setString(3,c.getCustomerPass());
            ps.setString(4,c.getCustomerContact());
            ps.setString(5,c.getCustomerAdd());
            ps.setInt(6,c.getCustomerID());
            result = ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }

        if(result > 0) {
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean DeleteCustomer(int CustomerID) {
        try{
            SQL = "delete from Customer where customerID =?";
            ps = con.prepareStatement(SQL);
            ps.setInt(1,CustomerID);
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
    public List<Customer> ShowAllCustomers() {
        List<Customer> CustomerList1 =new ArrayList<>();
        try{
            SQL ="select * from customer;";
            ps = con.prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){
                CustomerObj = new Customer();
                CustomerObj.setCustomerID(rs.getInt(1));
                CustomerObj.setCustomerName(rs.getString(2));
                CustomerObj.setCustomerEmail(rs.getString(3));
                CustomerObj.setCustomerPass(rs.getString(4));
                CustomerObj.setCustomerContact(rs.getString(5));
                CustomerObj.setCustomerAdd(rs.getString(6));
                CustomerList1.add(CustomerObj);
            }
            return CustomerList1;

        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Customer SearchByID(int CustomerID) {
        try{
            SQL ="select * from customer where customerid =?";
            ps = con.prepareStatement(SQL);
            ps.setInt(1,CustomerID);
            rs = ps.executeQuery();

            while(rs.next()){
                CustomerObj = new Customer();
                CustomerObj.setCustomerID(rs.getInt(1));
                CustomerObj.setCustomerName(rs.getString(2));/*In previous versions we used CustomerObj.getCustomerName() */
                CustomerObj.setCustomerEmail(rs.getString(3));
                CustomerObj.setCustomerPass(rs.getString(4));
                CustomerObj.setCustomerContact(rs.getString(5));
                CustomerObj.setCustomerAdd(rs.getString(6));

                return CustomerObj;
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Customer> SearchByName(String CustomerName) {
        List<Customer> list2 = new ArrayList<>();
        try{
            SQL = "select * from customer where customername =?";
            ps = con.prepareStatement(SQL);
            ps.setString(1,CustomerName);  /*In previous versions we used CustomerObj.getCustomerName() */
            rs = ps.executeQuery();
            while(rs.next()){
                CustomerObj = new Customer();
                CustomerObj.setCustomerID(rs.getInt(1));
                CustomerObj.setCustomerName(rs.getString(2));
                CustomerObj.setCustomerEmail(rs.getString(3));
                CustomerObj.setCustomerPass(rs.getString(4));
                CustomerObj.setCustomerContact(rs.getString(5));
                CustomerObj.setCustomerAdd(rs.getString(6));
                list2.add(CustomerObj);
            }
            return list2;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Customer SearchByEmail(String CustomerEmail) {
        try{
            SQL = "select * from customer where customeremail = ?";
            ps = con.prepareStatement(SQL);
            ps.setString(1,CustomerEmail);
            rs = ps.executeQuery();
            while(rs.next()){
                CustomerObj = new Customer();
                CustomerObj.setCustomerID(rs.getInt(1));
                CustomerObj.setCustomerName(rs.getString(2));
                CustomerObj.setCustomerEmail(rs.getString(3));
                CustomerObj.setCustomerPass(rs.getString(4));
                CustomerObj.setCustomerContact(rs.getString(5));
                CustomerObj.setCustomerAdd(rs.getString(6));
                return CustomerObj;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
