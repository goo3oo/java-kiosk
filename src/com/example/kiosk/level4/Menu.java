package com.example.kiosk.level4;
import java.util.*;

public class Menu {

    List<MenuItem> menuItems;
    String categoryName;

    public Menu(List<MenuItem> menuItems, String categoryName){
        this.menuItems = menuItems;
        this.categoryName = categoryName;
    }

    public List<MenuItem> getMenuItems(){
        return menuItems;
    }

    public String getCategoryName(){
        return categoryName;
    }
}
