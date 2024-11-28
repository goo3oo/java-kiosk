package com.example.kiosk.level5;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<MenuItem> cart = new ArrayList<>();

    public void addItem(MenuItem menuItem){
        cart.add(menuItem);
    }

    public void clearCart(){
        cart.clear();
    }
}
