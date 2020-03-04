package com.dao;

import com.pojo.Food;

import java.util.List;

public interface FoodDao {
    boolean AddFood(Food f);
    boolean UpdateFood(Food f);
    boolean DeleteFood(int FoodID);

    List<Food> ShowAllFood();
    Food ShowFoodByID(int FoodID);
    List<Food> ShowFoodByName(String FoodName);

}
