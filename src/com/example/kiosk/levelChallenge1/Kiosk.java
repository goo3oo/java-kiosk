package com.example.kiosk.levelChallenge1;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

    private final Scanner scan = new Scanner(System.in);
    private final List<Menu> menu; // 메뉴 카테고리 목록을 저장한 리스트
    private Menu category; // 사용자 선택에 따라 선택된 카테고리
    private MenuItem menuItem; // 사용자 선택에 따라 선택된 메뉴 항목
    private final Cart cart; // 장바구니 객체

    public Kiosk(List<Menu> menu, Cart cart) {
        this.menu = menu;
        this.cart = cart;
    }

    /**
     * 키오스크를 시작하는 메서드
     * 메인 메뉴에서 카테고리를 선택하고, 서브 메뉴에서 메뉴 항목을 선택 후 장바구니에 담는다.
     */
    public void start() {
        while (true) {
            int menuNumber = printMainMenu(); // 메인 메뉴 출력 후 메뉴 번호 반환
            int userInput = getValidInput(menuNumber); // 카테고리를 선택하기 위한 사용자 입력

            if (userInput == 0) {
                System.out.println("종료합니다.");
                return;
            } else if (userInput <= menu.size()) {
                // 카테고리 번호를 선택한 경우
                category = menu.get(userInput-1); // 카테고리 선택
                printSubMenu(); // 선택된 카테고리의 메뉴 항목 출력
                userInput = getValidInput(category.getMenuItems().size()); // 메뉴 항목을 선택하기 위한 사용자 입력
                if (userInput == 0) {
                    continue;  // 뒤로 가기 선택 시 반복문으로 돌아감
                }
                menuItem = category.getMenuItems().get(userInput-1); // 선택된 메뉴 항목 저장
                addToCart(); // 장바구니에 선택한 항목 추가
            } else if (userInput == menu.size()+1){
                // mainMenu 화면에서 Orders 항목 선택 시
                orderItem(); // 주문 시작
            } else  {
                // mainMenu 화면에서 Cancel 항목 선택 시
                System.out.println("진행중인 주문 취소완료");
                cart.clearCart(); // 장바구니 비우기
            }
        }
    }

    /**
     * 사용자로부터 유효한 메뉴 번호를 입력받는 메서드
     * 유효한 값이 입력될 때 까지 반복
     * @param size : 유효한 입력 범위의 상한 (0부터 size 까지의 값만 허용)
     * @return : 유효한 사용자 입력
     */
    public int getValidInput(int size) {
        int input;
        while (true) {
            try {
                input = scan.nextInt();
                if (input >= 0 && input <= size) {
                    return input; // 유효한 입력 반환
                } else {
                    System.out.println("유효하지 않은 메뉴 번호입니다. 다시 입력해주세요.");
                }
            } catch (InputMismatchException e) {
                System.out.println("메뉴 번호를 입력해주세요.");
                scan.nextLine(); // 잘못된 입력을 비우기
            }
        }
    }

    /**
     * 메인 메뉴 화면(카테고리 항목)을 출력하고, 유효한 메뉴 번호를 반환
     * @return : 선택 가능한 메뉴 번호
     */
    public int printMainMenu() {
        System.out.println("[ MAIN MENU ]");
        int menuNumber = 0;

        for (Menu menuElement : menu) {
            System.out.println((++menuNumber) + ". " + menuElement.getCategoryName());
        }
        System.out.println("0. 종료");
        if (!cart.getCartList().isEmpty()) {
            // 장바구니가 비어있지 않은 경우 실행
            System.out.println();
            System.out.println("[ ORDER MENU ]");
            System.out.println((menuNumber++) + ". Orders       | 장바구니를 확인 후 주문합니다.");
            System.out.println(menuNumber + ". Cancel       | 진행중인 주문을 취소합니다.");
            return menuNumber;
        }
        return menuNumber;
    }

    /**
     * 서브 메뉴 화면을 출력
     * 선택한 카테고리 메뉴 항목들을 출력
     */
    public void printSubMenu() {

        System.out.println("[ " + category.getCategoryName().toUpperCase() + " MENU ]");

        int menuNumber = 1;
            for (MenuItem menuItem : category.getMenuItems()) {
                System.out.printf("%-1d. %-20s | W %-4.1f | %s%n", menuNumber++, menuItem.getName(), menuItem.getPrice(), menuItem.getDescription());
            }
            System.out.println("0. 뒤로가기");
    }

    /**
     * 선택한 메뉴 항목을 장바구니에 추가하는 메서드
     */
    public void addToCart() {
        System.out.printf("%-20s | W %-4.1f | %s%n", menuItem.getName(), menuItem.getPrice(), menuItem.getDescription());
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1.확인"+"\t"+"2.취소");

        if( getValidInput(2) == 1){
            // 1, 2만 선택하므로 getValidInput 메서드의 매개변수에 2 입력
            // 1을 입력 시 실행
            cart.addItem(menuItem); // cartList 리스트에 저장
            System.out.println(menuItem.getName()+" 메뉴가 추가되었습니다.");
        }
    }

    /**
     * 장바구니 내 항목들을 출력하고, 주문 여부를 확인하는 메서드
     */
    public void orderItem(){
        System.out.println("아래와 같이 주문 하시겠습니까?");

        cart.printCartItem();  // 장바구니 내의 항목들을 출력
        printTotalPrice();  // 장바구니 내 항목들의 가격을 합산한 결과 출력

        System.out.println();
        System.out.println("1.주문       2.메뉴판");

      int selectOrder = getValidInput(2);  // 주문 또는 메뉴판 선택

      if(selectOrder==1){
          // 주문 완료
          System.out.println("주문이 완료되었습니다. 금액은 W " +getTotalPrice()+ " 입니다.");
          cart.clearCart(); // 주문 완료 시 장바구니 비우기
          System.out.println();
      }
    }

    /**
     * 장바구니의 총 가격을 계산하는 메서드
     * @return : 장바구니 내 모든 메뉴 항목들의 총 합계
     */
    public double getTotalPrice(){
        List<MenuItem> cartList = cart.getCartList();
        double totalPrice = 0;
        for(MenuItem item : cartList){
            totalPrice +=  item.getPrice();
        }return (double) Math.round(totalPrice * 100)/100; // 소수점 둘째 자리에서 반올림
    }

    /**
     * 장바구니의 총 가격을 출력하는 메서드
     */
    public void printTotalPrice(){
        System.out.println();
        System.out.println("[ TOTAL ]");
        System.out.println("W " + getTotalPrice());
    }
}
