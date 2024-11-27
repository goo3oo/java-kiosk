package com.example.kiosk.levelChallenge1;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<MenuItem> cartList = new ArrayList<>();

    public void addItem(MenuItem menuItem){
        cartList.add(menuItem);
    }
    public List<MenuItem> getCartList(){
        return cartList;
    }
    public void clearCart(){
        cartList.clear();
    }
    public void printCartItem(){
        System.out.println();
        System.out.println("[ Orders ]");
        for(MenuItem item : cartList){
            System.out.printf("%-20s | W %-4.1f | %s%n", item.getName(), item.getPrice(), item.getDescription());
        }
    }
}
