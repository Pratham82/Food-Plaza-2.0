package com.test;

import com.dao.FoodDao;
import com.dao.FoodDaoImpl;
import com.pojo.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FoodTest {
    public static void main(String []args){
        Scanner scan = new Scanner(System.in);
        //Food objects
        int FoodID;
        String FoodName, FoodCategory;
        double FoodPrice;


        //Choices
        int InitialChoice =0;
        char FinalChoice ;
        boolean flag;
        int showChoice= 0;

        //References from other classes
        Food FoodObj = new Food();
        FoodDao FoodDaoObj = new FoodDaoImpl();

        //Creating food list
        List<Food> FoodList = new ArrayList<Food>();

        //Stating Food plaza in console
        do{
            System.out.println("*****Welcome to Food Plaza*****");
            System.out.println("1. Add Food");
            System.out.println("2. Update Food");
            System.out.println("3. Delete Food");
            System.out.println("4. Show All Food");
            System.out.println("5. Show Food by ID/Name");

            System.out.print("Choose any option: ");
            InitialChoice = scan.nextInt();

            switch (InitialChoice){
                case 1:
                    System.out.println("*****Add Food*****");
                    System.out.print("Enter Food Name: ");
                    FoodName = scan.next();
                    System.out.print("Enter Food Category: ");
                    FoodCategory = scan.next();
                    System.out.print("Enter Food Price: ");
                    FoodPrice = scan.nextDouble();

                    FoodObj = new Food(FoodName,FoodCategory,FoodPrice);
                    flag = FoodDaoObj.AddFood(FoodObj);

                    if(flag){
                        System.out.println("Food added successfully");
                    }else{
                        System.out.println("Food has not been added ");
                    }
                    break;

                case 2:
                    System.out.println("*****Update Food*****");
                    System.out.print("Enter Food ID to update: ");
                    FoodID = scan.nextInt();
                    System.out.print("Enter Food Name: ");
                    FoodName = scan.next();
                    System.out.print("Enter Food Category: ");
                    FoodCategory = scan.next();
                    System.out.print("Enter Food Price: ");
                    FoodPrice = scan.nextDouble();

                    FoodObj = new Food(FoodID,FoodName,FoodCategory,FoodPrice);
                    flag = FoodDaoObj.UpdateFood(FoodObj);
                    if(flag){
                        System.out.println("Food added successfully");
                    }else{
                        System.out.println("Food has not been added ");
                    }
                    break;


                case 3:
                    System.out.println("*****Delete Food*****");
                    System.out.print("Enter Food ID to delete Food: ");
                    FoodID = scan.nextInt();
                    FoodObj.setFoodID(FoodID);
                    flag = FoodDaoObj.DeleteFood(FoodID);

                    if(flag){
                        System.out.println("Food Deleted successfully");
                    }else{
                        System.out.println("Food has not been added");
                    }
                    break;

                case 4:
                    System.out.println("*****Show All food*****");
                    FoodList = FoodDaoObj.ShowAllFood();
                    if(!FoodList.isEmpty()){
                        for(Food f1: FoodList){
                            System.out.println(f1);
                        }
                    }else{
                        System.out.println("Food list is empty");
                    }
                    break;

                case 5:
                    System.out.println("*****Show Food*****");
                    System.out.println("1. Show Food by ID ");
                    System.out.println("2. Show Food by name");
                    System.out.print("Enter choice: ");
                    showChoice= scan.nextInt();
                    switch(showChoice){
                        case 1:
                            System.out.print("Enter Food ID: ");
                            FoodID = scan.nextInt();
                            FoodObj.setFoodID(FoodID);
                            Food FoodObj2 = FoodDaoObj.ShowFoodByID(FoodID);
                            if(FoodObj2!=null){
                                System.out.println(FoodObj2);
                            }else{
                                System.out.println("Food is not present for this Food ID");
                            }
                            break;

                        case 2:
                            System.out.print("Enter Food Name: ");
                            FoodName = scan.next();
                            FoodObj.setFoodName(FoodName);
                            List<Food> FoodList2 = FoodDaoObj.ShowFoodByName(FoodName);
                            if(!FoodList2.isEmpty()){
                                for(Food f2: FoodList2){
                                    System.out.println(f2);
                                }
                            }else{
                                System.out.println("Food is not present for this Food Name");
                            }
                            break;

                        default:
                            System.out.println("Please enter valid choice");
                    }
                    break;
                default:
                    System.out.println("Please enter valid choice");
            }
            //Final choice for keep food plaza running
            System.out.print("If you want to continue Enter 'y' or 'Y' to continue: ");
            FinalChoice = scan.next().charAt(0);
        }while(FinalChoice =='y'||FinalChoice=='Y');

    }
}
