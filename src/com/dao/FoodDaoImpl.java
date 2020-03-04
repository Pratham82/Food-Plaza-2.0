package com.dao;

import com.pojo.Food;
import com.utility.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FoodDaoImpl implements FoodDao{
    //References from Food class
    Food FoodObj = null;

    //References from SQL
    Connection con = DBConnection.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    int Result;
    String SQL;


    //FoodDao FoodDaoObj = null;
    //List<Food> FoodList = new ArrayList<>();


    //ADD FOOD//
    @Override
    public boolean AddFood(Food f) {
        try{
            SQL="insert into food(foodname,foodcategory,foodprice) values(?,?,?)";
            ps = con.prepareStatement(SQL);
            ps.setString(1,f.getFoodName());
            ps.setString(2,f.getFoodCategory());
            ps.setDouble(3,f.getFoodPrice());
            Result = ps.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }
        if(Result>0){
            return true;
        }else{
            return false;
        }
    }

    //UPDATE FOOD//
    @Override
    public boolean UpdateFood(Food f) {
        try{
            SQL ="update food set foodname=?, foodcategory=?, foodprice=? where foodid=?";
            ps = con.prepareStatement(SQL);
            ps.setString(1,f.getFoodName());
            ps.setString(2,f.getFoodCategory());
            ps.setDouble(3,f.getFoodPrice());
            ps.setInt(4,f.getFoodID());
            Result = ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        if(Result>0){
            return true;
        }else{
            return false;
        }
    }

    //DELETE FOOD//
    @Override
    public boolean DeleteFood(int FoodID) {
        try{
            SQL ="delete from food where foodid = ?";
            ps = con.prepareStatement(SQL);
            ps.setInt(1,FoodID);
            Result = ps.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }
        if(Result>0){
            return true;
        }else{
            return false;
        }
    }

    //SHOW ALL FOOD//
    @Override
    public List<Food> ShowAllFood() {
        List<Food> NewFoodList = new ArrayList<>();
        try{
            SQL ="select * from food;";
            ps = con.prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){
                FoodObj =new Food();
                FoodObj.setFoodID(rs.getInt(1));
                FoodObj.setFoodName(rs.getString(2));
                FoodObj.setFoodCategory(rs.getString(3));
                FoodObj.setFoodPrice(rs.getDouble(4));
                NewFoodList.add(FoodObj);
            }
            return NewFoodList;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    //SHOW ALL FOOD//
    @Override
    public Food ShowFoodByID(int FoodID) {
        try{
            SQL = "select * from food where foodid= ?";
            ps = con.prepareStatement(SQL);
            ps.setInt(1,FoodID);
            rs = ps.executeQuery();
            while(rs.next()){
                FoodObj = new Food();
                FoodObj.setFoodID(rs.getInt(1));
                FoodObj.setFoodName(rs.getString(2));
                FoodObj.setFoodCategory(rs.getString(3));
                FoodObj.setFoodPrice(rs.getDouble(4));
                //return FoodObj;  //we can also return the object inside while loop
            }
            return FoodObj;
        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Food> ShowFoodByName(String FoodName) {
        List<Food> FoodList2= new ArrayList<Food>();
        try{
            SQL ="select * from food where foodname =?";
            ps = con.prepareStatement(SQL);
            ps.setString(1,FoodName);
            rs = ps.executeQuery();

            while(rs.next()){
                FoodObj= new Food();
                FoodObj.setFoodID(rs.getInt(1));
                FoodObj.setFoodName(rs.getString(2));
                FoodObj.setFoodCategory(rs.getString(3));
                FoodObj.setFoodPrice(rs.getDouble(4));
                FoodList2.add(FoodObj);
            }
            return FoodList2;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
