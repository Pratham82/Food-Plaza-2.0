package com.test;

import com.dao.OrdersDao;
import com.dao.OrdersDaoImpl;
import com.pojo.Cart;
import com.pojo.Orders;

import java.util.List;
import java.util.Scanner;

public class OrdersTest {
    public static void main(String []args){
        Scanner scan = new Scanner(System.in);
         int OrderID;
         double TotalPrice;
         String CustomerEmail;
         String OrderStatus;
         String OrderDate;

         //Choices
        int InitialChoice =0;
        int SearchChoice =0;
        char FinalChoice;
        boolean flag;

        //References from orders
        Orders o = new Orders();
        OrdersDao od = new OrdersDaoImpl();

        do{ System.out.println("******Order Management*****");
            System.out.println("*****1. Place new Order*****");
            System.out.println("*****2. Show all orders*****");
            System.out.println("*****3. Show my orders*****");

            System.out.print("Enter your choice: ");
            InitialChoice = scan.nextInt();
            switch(InitialChoice){
                case 1:
                    System.out.println("***** Place new Order*****");
                    System.out.print("Enter customer email for placing orders: ");
                    CustomerEmail = scan.next();
                    o.setCustomerEmail(CustomerEmail);

                    o = od.PlaceOrders(CustomerEmail);
                    if(o!=null){
                        System.out.println("Order placed");
                        System.out.println(o);
                    } else{
                        System.out.println("Orders placed");
                    }
                    break;

                case 2:
                    System.out.println("***** Show all orders*****");
                    List<Orders> list1 = od.ShowAllOrders();
                    if(!list1.isEmpty()){
                        for(Orders o1:list1){
                            System.out.println(o1);
                        }
                    }else{
                        System.out.println("Orders list is empty");
                    }
                    break;

                case 3:
                    System.out.println("***** Show my orders*****");
                    System.out.print("Enter customer email for searching orders: ");
                    CustomerEmail =scan.next();
                    List<Orders> list2 = od.ShowMyOrder(CustomerEmail);
                    if(!list2.isEmpty()){
                        for(Orders o1:list2){
                            System.out.println(o1);
                        }
                    }else{
                        System.out.println("Orders list is empty");
                    }
                    break;

                default:
                    System.out.println("Please enter correct choice");

            }
            System.out.print("If you want to continue enter 'y' or 'Y' ");
            FinalChoice =scan.next().charAt(0);
        }while(FinalChoice =='y'||FinalChoice=='Y');
    }
}

/*
Orders table query:
create table orders(orderid int primary key auto_increment, totalprice double, customeremail varchar(50), orderstatus varchar(50), orderdate varchar(50));
*/