package com.test;

import com.dao.CartDao;
import com.dao.CartDaoImpl;
import com.pojo.Cart;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CartTest {
    public static void main(String []args){
        Scanner scan = new Scanner(System.in);
         int CartID;
         int FoodID;
         String FoodName;
         String FoodCategory;
         double FoodPrice;
         String CustomerEmail;
         int Quantity;

        //Choices
        int InitialChoice =0;
        int SearchChoice =0;
        int DeleteChoice =0;
        char FinalChoice;
        boolean flag;

        //Reference
        Cart c = new Cart();
        CartDao cd = new CartDaoImpl();
        List<Cart> CartList = new ArrayList<Cart>();

        do{ System.out.println("******Customer Management*****");
            System.out.println("*****1. Add new Item to Cart*****");
            System.out.println("*****2. Update Cart*****");
            System.out.println("*****3. Delete Item from Cart*****");
            System.out.println("*****4. Show All Items from cart*****");
            System.out.println("*****5. Search Items in Cart*****");

            System.out.print("Enter your choice: ");
            InitialChoice = scan.nextInt();
            switch(InitialChoice){
                case 1:
                    System.out.println("***** Add new Item to Cart*****");
                    System.out.print("Enter Food ID: ");
                    FoodID = scan.nextInt();
                    System.out.print("Enter Customer Email: ");
                    CustomerEmail = scan.next();
                    System.out.print("Enter quantity: ");
                    Quantity = scan.nextInt();

                    c = new Cart(FoodID, CustomerEmail, Quantity);
                    flag = cd.AddToCart(c);

                    if(c!= null){
                        System.out.println("Item added successfully");
                    }else{
                    System.out.println("Item is not added to the cart");
                    }
                    break;

                case 2:
                    System.out.println("***** Update Cart*****");
                    System.out.print("Enter Cart ID for updating: ");
                    CartID = scan.nextInt();
                    System.out.print("Enter Food ID: ");
                    FoodID = scan.nextInt();
                    System.out.print("Enter Customer Email: ");
                    CustomerEmail = scan.next();
                    System.out.print("Enter quantity: ");
                    Quantity = scan.nextInt();

                    c = new Cart(CartID,FoodID, CustomerEmail, Quantity);
                    flag = cd.UpdateCart(c);

                    if(c!= null){
                        System.out.println("Item added successfully");
                    }else{
                        System.out.println("Item is not added to the cart");
                    }
                    break;

                case 3:
                    System.out.println("*****3. Delete Item from Cart*****");
                    System.out.println("1. Delete by Cart ID ");
                    System.out.println("2. Delete by Customer email:");
                    System.out.print("Enter choice for deleting: ");
                    DeleteChoice = scan.nextInt();
                    switch(DeleteChoice){
                        case 1:
                            System.out.print("Enter cart ID for deleting item: ");
                            CartID = scan.nextInt();
                            c.setCartID(CartID);
                            flag = cd.DeleteFromCartByCartID(CartID);

                            if(flag){
                                System.out.println("Item deleted successfully");
                            }else{
                                System.out.println("Item is not deleted successfully");
                            }
                            break;

                        case 2:
                            System.out.print("Enter Customer Email for deleting item: ");
                            CustomerEmail = scan.next();
                            c.setCustomerEmail(CustomerEmail);
                            flag = cd.DeleteFromCartByCustomerEmail(CustomerEmail);

                            if(flag){
                                System.out.println("Item deleted successfully");
                            }else{
                                System.out.println("Item is not deleted successfully");
                            }
                            break;

                    }


                    break;

                case 4:
                    System.out.println("*****Show All Items from cart*****");
                    List<Cart> list1 = cd.ShowAllItems();
                    if(!list1.isEmpty()){
                        for(Cart c1: list1){
                            System.out.println(c1);
                        }
                    }else{
                        System.out.println("Cart list is empty");
                    }
                    break;

                case 5:
                    System.out.println("***** Search Items in Cart*****");
                    System.out.println("1. Search from Cart ID ");
                    System.out.println("2. Search from Customer email:");
                    System.out.print("Enter choice for searching: ");
                    SearchChoice = scan.nextInt();
                    switch (SearchChoice){
                        case 1:
                            System.out.print("Enter cart ID for searching: ");
                            CartID = scan.nextInt();
                            c.setCartID(CartID);
                            Cart c1= cd.SearchFromCartByID(CartID);
                            if(c1 != null){
                                System.out.println(c1);
                            }else{
                                System.out.println("Item is not available for entered Cart ID");
                            }
                            break;

                        case 2:
                            System.out.print("Enter Customer email for searching: ");
                            CustomerEmail = scan.next();
                            c.setCustomerEmail(CustomerEmail);
                            Cart c2 =cd.SearchFromCartByCustomerEmail(CustomerEmail);
                            if(c2 !=null){
                                System.out.println(c2);
                            }else{
                                System.out.println("Item is not available for entered Cart ID");
                            }
                            break;
                    }
                    break;

            }
            System.out.print("If you want to continue enter 'y' or 'Y' ");
            FinalChoice =scan.next().charAt(0);
        }while(FinalChoice =='y'||FinalChoice=='Y');
    }
}

/*
create table cart(cartid int primary key auto_increment, foodid int, customeremail varchar(50),  quantity int);
* */