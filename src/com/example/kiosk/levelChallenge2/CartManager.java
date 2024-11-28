package com.example.kiosk.levelChallenge2;

import java.util.stream.IntStream;

public class CartManager {
    // 장바구니 관리 클래스

    private final Cart cart; // 생성한 cart 객체 저장

    // cart 객체 생성
    public CartManager() {
        this.cart = new Cart();
    }

    /**
     * cart 객체 반환
     * @return : CartManager 내의 cart 객체 반환
     */
    public Cart getCart() {
        return cart;
    }

    /**
     * cart 객체인 장바구니에 항목 추가
     * @param menuItem : 장바구니에 추가할 메뉴 항목
     */
    public void addItemToCart(MenuItem menuItem) {
        cart.addItem(menuItem);
    }

    /**
     * cart 객체인 장바구니에서 항목 삭제
     * @param userInput : 입력받은 값에 해당하는 메뉴 항목을 삭제
     */
    public void removeItemFromCart(int userInput) {
        cart.removeItem(userInput);
    }

    /**
     * 장바구니를 비우는 메서드
     * 장바구니 내의 모든 항목을 제거
     */
    public void clearCart() {
        cart.clearCart();
    }

    /**
     * 장바구니에 담긴 메뉴 항목들을 출력하는 메서드
     * 각 메뉴 항목의 이름, 가격, 설명을 출력
     */
    public void printCartItem() {
        System.out.println();
        System.out.println("[ Orders ]");
        IntStream.range(0, cart.getCartList().size())
                .forEach(i -> {
                    MenuItem item = cart.getCartList().get(i);
                    System.out.printf("%-1d. %-20s | W %-4.1f | %s%n", i + 1, item.getName(), item.getPrice(), item.getDescription());
                });
    }

    /**
     * 장바구니의 총 가격을 출력하는 메서드
     */
    public void printTotalPrice() {
        System.out.println();
        System.out.println("[ TOTAL ]");
        System.out.println("W " + getCart().getTotalPrice());
    }
}
