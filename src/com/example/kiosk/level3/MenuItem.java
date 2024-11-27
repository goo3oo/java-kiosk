
package com.example.kiosk.level3;

public class MenuItem {
    //버거 이름, 가격, 설명 멤버변수
    private final String burgerName;
    private final Double burgerPrice;
    private final String description;

    //이름, 가격, 설명 입력
    public MenuItem(String burgerName, Double burgerPrice, String description){
        this.burgerName = burgerName;
        this.burgerPrice = burgerPrice;
        this.description = description;
    }

    public String getBurgerName(){
        return burgerName;
    }

    public Double getBurgerPrice(){
        return burgerPrice;
    }

    public String getDescription(){
        return description;
    }
}
