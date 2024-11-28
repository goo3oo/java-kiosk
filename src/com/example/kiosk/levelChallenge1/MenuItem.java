package com.example.kiosk.levelChallenge1;

public class MenuItem {
    // 메뉴 항목 클래스

    private final String name; // 메뉴 항목의 이름
    private final Double price; // 메뉴 항목의 가격
    private final String description; // 메뉴 항목의 설명

    // MenuItem 생성자
    public MenuItem(String name, Double price, String description){
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName(){
        return name;
    }

    public Double getPrice(){
        return price;
    }

    public String getDescription(){
        return description;
    }
}


