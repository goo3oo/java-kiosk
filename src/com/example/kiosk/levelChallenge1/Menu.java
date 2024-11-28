package com.example.kiosk.levelChallenge1;

import java.util.List;

public class Menu {
    // 메뉴 항목들을 저장하는 리스트들을 관리
    private final List<MenuItem> menuItems; // 메뉴 항목들을 저장하는 리스트
    private final String categoryName; // 메뉴에 출력 할 카테고리 이름

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
