package com.pojo;

public class Cart {
    private int CartID;
    private int FoodID;
    private String FoodName;
    private String FoodCategory;
    private double FoodPrice;
    private String CustomerEmail;
    private int Quantity;

    @Override
    public String toString() {
        return "Cart{" +
                "CartID=" + CartID +
                ", FoodID=" + FoodID +
                ", FoodName='" + FoodName + '\'' +
                ", FoodCategory='" + FoodCategory + '\'' +
                ", FoodPrice=" + FoodPrice +
                ", CustomerEmail='" + CustomerEmail + '\'' +
                ", Quantity=" + Quantity +
                '}';
    }

    public Cart() {
    }

    public Cart(int foodID, String customerEmail, int quantity) {
        FoodID = foodID;
        CustomerEmail = customerEmail;
        Quantity = quantity;
    }

    public Cart(int cartID, int foodID, String customerEmail, int quantity) {
        CartID = cartID;
        FoodID = foodID;
        CustomerEmail = customerEmail;
        Quantity = quantity;
    }

    public Cart(int cartID, int foodID, String foodName, String foodCategory, double foodPrice, String customerEmail, int quantity) {
        CartID = cartID;
        FoodID = foodID;
        FoodName = foodName;
        FoodCategory = foodCategory;
        FoodPrice = foodPrice;
        CustomerEmail = customerEmail;
        Quantity = quantity;
    }

    public int getCartID() {
        return CartID;
    }

    public void setCartID(int cartID) {
        CartID = cartID;
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

    public String getCustomerEmail() {
        return CustomerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        CustomerEmail = customerEmail;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }
}
