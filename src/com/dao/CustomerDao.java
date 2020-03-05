package com.dao;

import com.pojo.Customer;

import java.util.List;

public interface CustomerDao {
    boolean AddCustomer(Customer c);
    boolean UpdateCustomer(Customer c);
    boolean DeleteCustomer(int CustomerID);

    List<Customer> ShowAllCustomers();
    Customer SearchByID(int CustomerID);
    List<Customer> SearchByName(String CustomerName);
    Customer SearchByEmail(String CustomerEmail);

}
