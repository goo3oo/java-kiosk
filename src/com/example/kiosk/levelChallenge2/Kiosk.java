package com.example.kiosk.levelChallenge2;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Kiosk {

    private final List<Menu> menu; // 메뉴 카테고리 목록을 저장한 리스트
    private final CartManager cartManager; // 장바구니 관리자 객체
    private final InputValidator inputValidator = new InputValidator(); // 사용자 입력 유효성 검사 객체

    private Menu category; // 사용자 선택에 따라 선택된 카테고리
    private MenuItem menuItem; // 사용자 선택에 따라 선택된 메뉴 항목

    // 생성자: 메뉴 목록과 장바구니 관리자 객체를 초기화
    public Kiosk(List<Menu> menu, CartManager cartmanager) {
        this.menu = menu;
        this.cartManager = cartmanager;
    }

    /**
     * 키오스크를 시작하는 메서드
     * 메인 메뉴에서 카테고리를 선택하고, 서브 메뉴에서 메뉴 항목을 선택 후 장바구니에 담는다.
     */
    public void start() {
        while (true) {
            int menuNumber = printMainMenu();  // 메인 메뉴 출력 후 메뉴 번호 반환
            int userInput = getValidInput(menuNumber);  // 카테고리 선택을 위한 사용자 입력

            if (userInput == 0) {
                System.out.println("종료합니다.");
                return; // 종료
            } else if (userInput <= menu.size()) {
                // 카테고리 번호를 선택한 경우
                category = menu.get(userInput - 1); // 카테고리 선택
                printSubMenu(); // 선택된 카테고리의 메뉴 항목 출력
                userInput = getValidInput(category.getMenuItems().size()); // 메뉴 항목 선택
                if (userInput == 0) {
                    continue; // 뒤로 가기 선택 시 반복문으로 돌아감
                }
                menuItem = category.getMenuItems().get(userInput - 1); // 선택된 메뉴 항목 저장
                addToCart(); // 장바구니에 선택한 항목 추가
            } else if (userInput == menu.size() + 1) {
                // Orders 항목 선택 시
                orderItem(); // 주문 시작
            } else {
                // Cancel 항목 선택 시
                System.out.println("진행중인 주문 취소완료");
                cartManager.clearCart(); // 장바구니 비우기
            }
        }
    }

    // 유효한 입력값을 받는 메서드
    public int getValidInput(int size) {
        return inputValidator.getValidInput(size);
    }

    /**
     * 메인 메뉴 화면을 출력하고, 유효한 메뉴 번호를 반환
     *
     * @return : 선택 가능한 메뉴 번호
     */
    public int printMainMenu() {
        System.out.println("[ MAIN MENU ]");

        AtomicInteger menuNumber = new AtomicInteger();
        menu.stream()
                .forEach(item -> System.out.println(menuNumber.incrementAndGet() + ". " + item.getCategoryName()));

        System.out.println("0. 종료");
        if (!cartManager.getCart().getCartList().isEmpty()) {
            // 장바구니에 항목이 있을 경우 주문 메뉴 표시
            System.out.println();
            System.out.println("[ ORDER MENU ]");
            System.out.println((menuNumber.incrementAndGet()) + ". Orders       | 장바구니를 확인 후 주문합니다.");
            System.out.println(menuNumber.incrementAndGet() + ". Cancel       | 진행중인 주문을 취소합니다.");
        }
        return menuNumber.get(); // 장바구니가 비어있으면 일반 메뉴 번호만 반환
    }

    /**
     * 서브 메뉴 화면을 출력
     * 선택한 카테고리의 메뉴 항목들을 출력
     */
    public void printSubMenu() {
        System.out.println("[ " + category.getCategoryName().toUpperCase() + " MENU ]");

        IntStream.range(0, category.getMenuItems().size())
                .forEach(i -> {
                    MenuItem item = category.getMenuItems().get(i);
                    System.out.printf("%-1d. %-20s | W %-4.1f | %s%n", i + 1, item.getName(), item.getPrice(), item.getDescription());
                });

        System.out.println("0. 뒤로가기");
    }

    /**
     * 선택된 메뉴 항목을 장바구니에 추가하는 메서드
     */
    public void addToCart() {
        System.out.printf("%-20s | W %-4.1f | %s%n", menuItem.getName(), menuItem.getPrice(), menuItem.getDescription());
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1.확인" + "\t" + "2.취소");

        if (getValidInput(2) == 1) {
            // 장바구니에 항목을 추가
            cartManager.addItemToCart(menuItem);
            System.out.println(menuItem.getName() + " 메뉴가 추가되었습니다.");
        }
    }

    /**
     * 장바구니 내 항목들을 출력하고, 주문 여부를 확인하는 메서드
     */
    public void orderItem() {
        System.out.println("아래와 같이 주문 하시겠습니까?");

        cartManager.printCartItem();  // 장바구니 내 항목들 출력
        cartManager.printTotalPrice(); // 장바구니 가격 합산 출력

        System.out.println();
        System.out.println("1.주문" + "\t" + "2.메뉴 삭제" + "\t" + "3.메뉴판");

        int selectOrder = getValidInput(3); // 주문 또는 메뉴판 선택

        if (selectOrder == 1) {
            // 주문 완료
            printDiscountedPrice();
            cartManager.clearCart(); // 주문 완료 후 장바구니 비우기
            System.out.println();
        } else if (selectOrder == 2) {
            System.out.println("삭제할 메뉴번호를 입력해주세요.");
            cartManager.removeItemFromCart(getValidInput(cartManager.getCart().getCartList().size()));
        }
    }

    /**
     * 할인 메뉴를 출력하는 메서드
     *
     * @return : 선택 가능한 할인 메뉴 번호
     */
    public int printDiscountMenu() {
        System.out.println("할인 정보를 입력해주세요.");
        int menuNumber = 1;
        for (DiscountRate list : DiscountRate.values()) {
            System.out.println(menuNumber++ + ". " + list.getDiscountCategory() + "\t" + " : " + list.getDiscountRate());
        }
        return menuNumber;
    }

    /**
     * 사용자로부터 할인 항목을 선택 받고, 할인율을 적용한 가격을 출력하는 메서드
     */
    public void printDiscountedPrice() {
        int menuNumber = printDiscountMenu();
        int userInput = getValidInput(menuNumber);
        double discountedPrice = switch (DiscountRate.toEnum(userInput)) {
            case NATIONALMERIT -> cartManager.getCart().getDiscountedPrice(DiscountRate.NATIONALMERIT);
            case MILITARYPERSONNEL -> cartManager.getCart().getDiscountedPrice(DiscountRate.MILITARYPERSONNEL);
            case STUDENT -> cartManager.getCart().getDiscountedPrice(DiscountRate.STUDENT);
            case NORMAL -> cartManager.getCart().getDiscountedPrice(DiscountRate.NORMAL);
        };
        System.out.println("주문이 완료되었습니다. 금액은 W " + discountedPrice + " 입니다.");
    }
}
