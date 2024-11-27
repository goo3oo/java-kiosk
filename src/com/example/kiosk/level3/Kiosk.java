package com.example.kiosk.level3;

import java.util.*;

public class Kiosk {
    private final List<MenuItem> menuItem;

    public Kiosk(List<MenuItem> menuItem) {
        this.menuItem = menuItem;
    }

    public void start() {
        while (true) {
            Scanner scan = new Scanner(System.in);

            System.out.println("[ SHAKE SHACK MENU ]");
            int menuNumber = 1;
            for (MenuItem menu : menuItem) {
                if (menu.getBurgerName().equals("종료")) {
                    System.out.println("0. 종료            | " + menu.getDescription());
                } else {
                    System.out.println((menuNumber++) + ". " + menu.getBurgerName() + "\t" + "  | W " + menu.getBurgerPrice() + " | " + menu.getDescription());
                }
            }
            System.out.print("메뉴 번호를 선택하세요: ");
            int userInput = -1;

            try {
                userInput = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력해주세요.");
                scan.nextLine();
            }

            if(userInput==0){
                System.out.println("종료합니다.");
            }else if(userInput>=0 && userInput<menuNumber){
                selectMenu(menuItem, userInput);
            }else{
                System.out.println("유효한 메뉴번호가 아닙니다. 다시 입력해주세요.");
            }
        }
    }
    public static void selectMenu(List<MenuItem> menuItems, int userInput) {
        MenuItem selectedItem = menuItems.get(userInput);
        System.out.print("선택한 메뉴 : ");
        System.out.println(selectedItem.getBurgerName() + ", " + selectedItem.getBurgerPrice() + ", " + selectedItem.getDescription());
    }

}