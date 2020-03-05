package com.pojo;

public class Customer {
    private int CustomerID;
    private String CustomerName;
    private String CustomerEmail;
    private String CustomerPass;
    private String CustomerContact;
    private String CustomerAdd;

    public Customer() {

    }

    public Customer(String customerName, String customerEmail, String customerPass, String customerContact, String customerAdd) {
        CustomerName = customerName;
        CustomerEmail = customerEmail;
        CustomerPass = customerPass;
        CustomerContact = customerContact;
        CustomerAdd = customerAdd;
    }

    public Customer(int customerID, String customerName, String customerEmail, String customerPass, String customerContact, String customerAdd) {
        CustomerID = customerID;
        CustomerName = customerName;
        CustomerEmail = customerEmail;
        CustomerPass = customerPass;
        CustomerContact = customerContact;
        CustomerAdd = customerAdd;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "CustomerID=" + CustomerID +
                ", CustomerName='" + CustomerName + '\'' +
                ", CustomerEmail='" + CustomerEmail + '\'' +
                ", CustomerPass='" + CustomerPass + '\'' +
                ", CustomerContact='" + CustomerContact + '\'' +
                ", CustomerAdd='" + CustomerAdd + '\'' +
                '}';
    }


    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getCustomerEmail() {
        return CustomerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        CustomerEmail = customerEmail;
    }

    public String getCustomerPass() {
        return CustomerPass;
    }

    public void setCustomerPass(String customerPass) {
        CustomerPass = customerPass;
    }

    public String getCustomerContact() {
        return CustomerContact;
    }

    public void setCustomerContact(String customerContact) {
        CustomerContact = customerContact;
    }

    public String getCustomerAdd() {
        return CustomerAdd;
    }

    public void setCustomerAdd(String customerAdd) {
        CustomerAdd = customerAdd;
    }


}
