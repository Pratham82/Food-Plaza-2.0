package com.test;

import com.dao.CustomerDao;
import com.dao.CustomerDaoImpl;
import com.pojo.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerTest {
    public static void main(String []args){
        Scanner scan  = new Scanner(System.in);
         int CustomerID;
         String CustomerName;
         String CustomerEmail;
         String CustomerPass;
         String CustomerContact;
         String CustomerAdd;

         //References from Customer
        Customer CustomerObj = new Customer();
        CustomerDao CustomerDaoObj = new CustomerDaoImpl();
        List<Customer> CustomerList = new ArrayList<Customer>();

        //Choices
        int InitialChoice =0;
        int SearchChoice =0;
        char FinalChoice;
        boolean flag;

        do{
            System.out.println("******Customer Management*****");
            System.out.println("*****1. Add Customer*****");
            System.out.println("*****2. Update Customer*****");
            System.out.println("*****3. Delete Customer*****");
            System.out.println("*****4. Show All Customers*****");
            System.out.println("*****5. Search Customer by ID/Name/Email*****");
            System.out.print("Enter your choice: ");
            InitialChoice = scan.nextInt();

            switch(InitialChoice){
                case 1:
                    System.out.println("*****Add a new Customer*****");
                    System.out.print("Enter Customer Name: ");
                    CustomerName =scan.next();
                    System.out.print("Enter Customer Email: ");
                    CustomerEmail =scan.next();
                    System.out.print("Enter Customer Password: ");
                    CustomerPass =scan.next();
                    System.out.print("Enter Customer Contact: ");
                    CustomerContact =scan.next();
                    System.out.print("Enter Customer Address: ");
                    CustomerAdd =scan.next();

                    CustomerObj = new Customer(CustomerName,CustomerEmail,CustomerPass,CustomerContact,CustomerAdd);
                    flag = CustomerDaoObj.AddCustomer(CustomerObj);

                    if(CustomerObj!=null){
                        System.out.println("Customer is added successfully");
                    }else{
                        System.out.println("Customer is not added");
                    }
                    break;

                case 2:
                    System.out.println("*****Update a new Customer*****");
                    System.out.println("Enter customer ID to update Customer: ");
                    CustomerID = scan.nextInt();
                    System.out.print("Enter Customer Name: ");
                    CustomerName =scan.next();
                    System.out.print("Enter Customer Email: ");
                    CustomerEmail =scan.next();
                    System.out.print("Enter Customer Password: ");
                    CustomerPass =scan.next();
                    System.out.print("Enter Customer Contact: ");
                    CustomerContact =scan.next();
                    System.out.print("Enter Customer Address: ");
                    CustomerAdd =scan.next();

                    CustomerObj = new Customer(CustomerID,CustomerName,CustomerEmail,CustomerPass,CustomerContact,CustomerAdd);
                    flag = CustomerDaoObj.UpdateCustomer(CustomerObj);

                    if(CustomerObj!=null){
                        System.out.println("Customer is updated successfully");
                    }else{
                        System.out.println("Customer is not updated");
                    }
                    break;

                case 3:
                    System.out.println("******Delete Customer*****");
                    System.out.print("Enter Customer ID for deleting customer: ");
                    CustomerID = scan.nextInt();
                    CustomerObj.setCustomerID(CustomerID);
                    flag = CustomerDaoObj.DeleteCustomer(CustomerID);

                    if(flag){
                        System.out.println("Customer is deleted");
                    }else{
                        System.out.println("Customer is not deleted ");
                    }

                    break;

                case 4:
                    System.out.println("*****Show all Customers*****");
                    CustomerList = CustomerDaoObj.ShowAllCustomers();
                    if(!CustomerList.isEmpty()){
                        for(Customer c1 :CustomerList){
                            System.out.println(c1);
                        }
                    }else{
                        System.out.println("Customer list is empty");
                    }
                    break;

                case 5:
                    System.out.println("*****Search by Customer ID/Name/Email");
                    System.out.println("1. Search Customer by ID");
                    System.out.println("2. Search Customer by Name");
                    System.out.println("3. Search Customer by Email");
                    System.out.print("Enter your choice: ");
                    SearchChoice =scan.nextInt();

                    switch(SearchChoice){
                        case 1:
                            System.out.print("Enter Customer ID to search: ");
                            CustomerID = scan.nextInt();
                            CustomerObj.setCustomerID(CustomerID);

                            Customer c2 = CustomerDaoObj.SearchByID(CustomerID);

                            if(c2!=null){
                                System.out.println(c2);
                            }else{
                                System.out.println("Customer is not available for entered customer ID");
                            }
                            break;


                        case 2:
                            System.out.println("Enter customer Name: ");
                            System.out.print("Enter customer name to search: ");
                            CustomerName =scan.next();
                            CustomerObj.setCustomerName(CustomerName);

                            List<Customer> list1 = CustomerDaoObj.SearchByName(CustomerName);
                            if(list1 !=null){
                                for(Customer c3: list1){
                                    System.out.println(c3);
                                }
                            }else{
                                System.out.println("Customer is not available for enter customer Name");
                            }
                            break;
                        case 3:
                            System.out.print("Enter Customer Email to search: ");
                            CustomerEmail = scan.next();
                            CustomerObj.setCustomerEmail(CustomerEmail);

                            Customer c3 = CustomerDaoObj.SearchByEmail(CustomerEmail);

                            if(c3!=null){
                                System.out.println(c3);
                            }else{
                                System.out.println("Customer is not available for entered customer Email");
                            }
                            break;
                        default:
                            System.out.println("Please enter a correct choice ");
                    }
                    break;
            }
            System.out.print("If you want to continue enter 'y' or 'Y' ");
            FinalChoice =scan.next().charAt(0);
        }while(FinalChoice =='y'||FinalChoice=='Y');




    }
}

/*
 *Customer table:
 create table customer(CustomerID int primary key auto_increment,CustomerName varchar(50), CustomerEmail varchar(50), CustomerPass varchar(50), CustomerContact varchar(50), CustomerAdd varchar(50));
         String ;
         String CustomerEmail;
         String CustomerPass;
         String CustomerContact;
         String CustomerAdd;)
 */

