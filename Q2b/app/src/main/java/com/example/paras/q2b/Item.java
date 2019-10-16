package com.example.paras.q2b;

/**
 * Created by Paras on 16-10-2019.
 */

public class Item {
    String food;
    String price;
    int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Item(String food, String price) {
        this.food = food;
        this.price = price;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
