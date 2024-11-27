package com.example.kiosk.levelChallenge1;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private final Scanner scan = new Scanner(System.in);
    private final List<Menu> menu;
    private Menu category;
    private MenuItem menuItem;
    private final Cart cart;

    public Kiosk(List<Menu> menu, Cart cart) {
        this.menu = menu;
        this.cart = cart;
    }

    public void run() {
        while (true) {
            int menuNumber = printMainMenu();
            int userInput = getValidInput(menuNumber);

            if (userInput == 0) {
                System.out.println("종료합니다.");
                return;
            } else if (userInput <= menu.size()) {
                category = menu.get(userInput-1);
                printSubMenu();
                userInput = getValidInput(category.getMenuItems().size());
                if (userInput == 0) {
                    continue;
                }
                menuItem = category.getMenuItems().get(userInput-1);
                addToCart();
            } else if (userInput == menu.size()+1){
                orderItem(userInput);
            } else  {
                System.out.println("진행중인 주문 취소완료");
                cart.clearCart();
            }
        }
    }

    public int getValidInput(int size) {
        int input;
        while (true) {
            try {
                input = scan.nextInt();
                if (input >= 0 && input <= size) {
                    return input;
                } else {
                    System.out.println("유효하지 않은 메뉴 번호입니다. 다시 입력해주세요.");
                }
            } catch (InputMismatchException e) {
                System.out.println("메뉴 번호를 입력해주세요.");
                scan.nextLine();
            }
        }
    }

    public int printMainMenu() {
        System.out.println("[ MAIN MENU ]");
        //여기 if를 때려도 되겠네???
        int menuNumber = 1;

        for (Menu menuElement : menu) {
            System.out.println((menuNumber++) + ". " + menuElement.getCategoryName());
        }
        System.out.println("0. 종료");
        if (!cart.getCartList().isEmpty()) {
            System.out.println();
            System.out.println("[ ORDER MENU ]");
            System.out.println((menuNumber++) + ". Orders       | 장바구니를 확인 후 주문합니다.");
            System.out.println(menuNumber + ". Cancel       | 진행중인 주문을 취소합니다.");
            return menuNumber;
        }
        return menuNumber;
    }

    public void printSubMenu() {

        System.out.println("[ " + category.getCategoryName().toUpperCase() + " MENU ]");

        int menuNumber = 1;
            for (MenuItem menuItem : category.getMenuItems()) {
                System.out.printf("%-1d. %-20s | W %-4.1f | %s%n", menuNumber++, menuItem.getName(), menuItem.getPrice(), menuItem.getDescription());
            }
            System.out.println("0. 뒤로가기");
    }


    public void addToCart() {
        System.out.printf("%-20s | W %-4.1f | %s%n", menuItem.getName(), menuItem.getPrice(), menuItem.getDescription());
        cart.addItem(menuItem);
    }

    public void orderItem(int userInput){
        System.out.println("아래와 같이 주문 하시겠습니까?");

        cart.printCartItem();
        printTotalPrice();

        System.out.println();
        System.out.println("1.주문       2.메뉴판");


      int selectOrder = getValidInput(2);

      if(selectOrder==1){
          System.out.println("주문이 완료되었습니다. 금액은 W " +getTotalPrice()+ " 입니다.");
          cart.clearCart();
          System.out.println();
      }
    }

    public double getTotalPrice(){
        List<MenuItem> cartList = cart.getCartList();
        double totalPrice = 0;
        for(MenuItem item : cartList){
            totalPrice +=  item.getPrice();
        }return totalPrice;
    }

    public void printTotalPrice(){
        System.out.println();
        System.out.println("[ TOTAL ]");
        System.out.println("W " + getTotalPrice());
    }
}
