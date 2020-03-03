package com.pojo;

public class Food {
    private int FoodID;
    private String FoodName;
    private String FoodCategory;
    private double FoodPrice;

    public Food() {

    }

    public Food(String foodName, String foodCategory, double foodPrice) {
        FoodName = foodName;
        FoodCategory = foodCategory;
        FoodPrice = foodPrice;
    }

    public Food(int foodID, String foodName, String foodCategory, double foodPrice) {
        FoodID = foodID;
        FoodName = foodName;
        FoodCategory = foodCategory;
        FoodPrice = foodPrice;
    }

    @Override
    public String toString() {
        return "Food{" +
                "FoodID=" + FoodID +
                ", FoodName='" + FoodName + '\'' +
                ", FoodCategory='" + FoodCategory + '\'' +
                ", FoodPrice=" + FoodPrice +
                '}';
    }

    public int getFoodID() {
        return FoodID;
    }

    public void setFoodID(int foodID) {
        FoodID = foodID;
    }

    public String getFoodName() {
        return FoodName;
    }

    public void setFoodName(String foodName) {
        FoodName = foodName;
    }

    public String getFoodCategory() {
        return FoodCategory;
    }

    public void setFoodCategory(String foodCategory) {
        FoodCategory = foodCategory;
    }

    public double getFoodPrice() {
        return FoodPrice;
    }

    public void setFoodPrice(double foodPrice) {
        FoodPrice = foodPrice;
    }
}
