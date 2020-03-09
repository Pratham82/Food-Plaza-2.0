package com.pojo;

public class Orders {
    private int OrderID;
    private double TotalPrice;
    private String CustomerEmail;
    private String OrderStatus;
    private String OrderDate;

    @Override
    public String toString() {
        return "Orders{" +
                "OrderID=" + OrderID +
                ", TotalPrice=" + TotalPrice +
                ", CustomerEmail='" + CustomerEmail + '\'' +
                ", OrderStatus='" + OrderStatus + '\'' +
                ", OrderDate='" + OrderDate + '\'' +
                '}';
    }

    public Orders() {
    }

    public Orders(double totalPrice, String customerEmail, String orderStatus, String orderDate) {
        TotalPrice = totalPrice;
        CustomerEmail = customerEmail;
        OrderStatus = orderStatus;
        OrderDate = orderDate;
    }

    public Orders(int orderID, double totalPrice, String customerEmail, String orderStatus, String orderDate) {
        OrderID = orderID;
        TotalPrice = totalPrice;
        CustomerEmail = customerEmail;
        OrderStatus = orderStatus;
        OrderDate = orderDate;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int orderID) {
        OrderID = orderID;
    }

    public double getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        TotalPrice = totalPrice;
    }

    public String getCustomerEmail() {
        return CustomerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        CustomerEmail = customerEmail;
    }

    public String getOrderStatus() {
        return OrderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        OrderStatus = orderStatus;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String orderDate) {
        OrderDate = orderDate;
    }
}
