package com.example.kiosk.level5;

import java.util.List;

public class Menu {

    private final List<MenuItem> menuItems;
    private final String categoryName;

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
