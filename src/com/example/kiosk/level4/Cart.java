package com.example.kiosk.level4;
import java.util.*;

public class Cart {
    public List<MenuItem> cart = new ArrayList<>();

    public void addItem(MenuItem menuItem){
        cart.add(menuItem);
    }

    public void clearCart(){
        cart.clear();
    }
}
