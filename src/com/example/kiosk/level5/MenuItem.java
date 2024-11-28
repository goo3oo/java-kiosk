package com.example.kiosk.level5;

public class MenuItem {
    //버거 이름, 가격, 설명 멤버변수
    private final String name;
    private final Double price;
    private final String description;

    //이름, 가격, 설명 입력
    public MenuItem(String name, Double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}

