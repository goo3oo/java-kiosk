package com.example.kiosk.levelChallenge2;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    // 장바구니 클래스: 선택한 메뉴 항목을 저장

    private final List<MenuItem> cartList; // 장바구니에 담은 메뉴 항목들을 저장할 리스트

    // 장바구니 생성 시 cartList 객체 생성
    public Cart(){
        this.cartList = new ArrayList<>();
    }

    /**
     * 장바구니의 메뉴 항목 리스트 getter
     * @return : 장바구니 내의 메뉴 항목 리스트
     */
    public List<MenuItem> getCartList() {
        return cartList;
    }

    /**
     * 장바구니에 선택한 메뉴 항목을 추가하는 메서드
     * @param menuItem : 장바구니에 추가할 메뉴 항목
     */
    public void addItem(MenuItem menuItem) {
        cartList.add(menuItem);
    }

    /**
     * 선택한 메뉴 항목을 장바구니에서 삭제하는 메서드
     * @param userInput : 입력받은 값에 해당하는 메뉴 항목을 삭제
     */
    public void removeItem(int userInput){
        String itemName = cartList.get(userInput-1).getName(); // 삭제할 항목의 이름 가져오기

        // 스트림을 사용해 해당 이름과 일치하는 항목들을 찾아 삭제
        List<MenuItem> toRemove = cartList.stream()
                .filter(item -> itemName.equals(item.getName()))
                .toList();

        cartList.removeAll(toRemove); // 일치하는 항목을 모두 삭제
        System.out.println(itemName + " 메뉴가 삭제되었습니다.");
        System.out.println();
    }

    /**
     * 장바구니를 비우는 메서드
     * 장바구니 내의 모든 항목을 제거
     */
    public void clearCart() {
        cartList.clear();
    }

    /**
     * 장바구니의 총 가격을 계산하는 메서드
     * @return : 장바구니 내 모든 메뉴 항목들의 총 합계
     */
    public double getTotalPrice(){
        double totalPrice = 0;
        for(MenuItem item : cartList){
            totalPrice +=  item.getPrice();
        }
        return (double) Math.round(totalPrice * 100)/100; // 소수점 둘째 자리에서 반올림하여 반환
    }

    /**
     * 장바구니 내 항목들의 가격 합산에 적용할 할인율을 계산하는 메서드
     * @param discountRateValue : 할인율을 정의한 DiscountRate 이넘클래스 객체
     * @return : 할인된 총 가격
     */
    public double getDiscountedPrice(DiscountRate discountRateValue){
        return Math.round(getTotalPrice() * discountRateValue.getDiscount() * 100.0) / 100.0;
    }
}
