package com.example.kiosk.levelChallenge1;

import java.util.*;

public class Cart {
    // 장바구니 클래스 : 선택한 메뉴 항목을 저장하고 관리

    private final List<MenuItem> cartList = new ArrayList<>(); // 선택한 메뉴 항목들을 저장할 리스트

    /**
     * 장바구니 메뉴 항목 리스트 getter
     * @return : 장바구니 내의 메뉴 항목 리스트
     */
    public List<MenuItem> getCartList(){
        return cartList;
    }

    /**
     * 장바구니에 선택한 메뉴 항목을 추가하는 메서드
     * @param menuItem : 장바구니에 추가할 메뉴 항목
     */
    public void addItem(MenuItem menuItem){
        // 선택한 항목을 cartList 리스트에 저장
        cartList.add(menuItem);
    }

    /**
     * 장바구니를 비우는 메서드
     * 장바구니 내의 모든 항목을 제거
     */
    public void clearCart(){
        // 장바구니 비우기
        cartList.clear();
    }

    /**
     * 장바구니에 담긴 메뉴 항목들을 출력하는 메서드
     * 각 메뉴 항목의 이름, 가격, 설명을 출력
     */
    public void printCartItem(){
        System.out.println();
        System.out.println("[ Orders ]");
        for(MenuItem item : cartList){
            System.out.printf("%-20s | W %-4.1f | %s%n", item.getName(), item.getPrice(), item.getDescription());
        }
    }
}
