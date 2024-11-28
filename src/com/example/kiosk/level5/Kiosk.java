package com.example.kiosk.level5;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private final Scanner scan = new Scanner(System.in);
    private final List<Menu> menu;

    public Kiosk(List<Menu> menu) {
        this.menu = menu;
    }

    public void run() {
        while (true) {
            printMainMenu();
            int mainInput = selectMenuitem();

            if (mainInput == 0) {
                System.out.println("종료합니다.");
                return;
            } else if (mainInput > 0 && mainInput <= menu.size()) {
                printSubMenu(mainInput);
                int subInput = selectMenuitem();
                if (subInput == 0) {
                    break;
                } else if (subInput > 0 && subInput <= menu.get(mainInput - 1).getMenuItems().size()) {
                    MenuItem menuItem = menu.get(mainInput - 1).getMenuItems().get(subInput - 1);
                    System.out.printf("선택한 메뉴 : %-10s | W %-3.1f | %s%n", menuItem.getName(), menuItem.getPrice(), menuItem.getDescription());
                } else {
                    System.out.println("유효한 메뉴 번호가 아닙니다. 다시 입력해주세요.");
                    scan.nextLine();
                    continue;
                }
            } else {
                System.out.println("유효한 메뉴 번호가 아닙니다. 다시 입력해주세요.");
                continue;
            }

        }
    }
    private int selectMenuitem() {
        while (true) {
            try {
                System.out.print("메뉴를 선택하세요 : ");
                return scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("유효한 메뉴번호가 아닙니다. 다시 입력해주세요.");
                scan.nextLine();
            }
        }
    }

    private void printMainMenu() {
        System.out.println("[ MAIN MENU ]");

        int menuNumber = 1;
        for (Menu menu1 : menu) {
            System.out.println((menuNumber++) + ". " + menu1.getCategoryName());
        }
        System.out.println("0. 종료");
    }

    private void printSubMenu(int userInput) {
        Menu selectedMenu = menu.get(userInput - 1);
        System.out.println("[ " + selectedMenu.getCategoryName().toUpperCase() + " MENU ]");

        int menuNumber = 1;
        for (MenuItem menuItem : selectedMenu.getMenuItems()) {
            System.out.printf("%-1d. %-20s | W %-4.1f | %s%n", menuNumber++, menuItem.getName(), menuItem.getPrice(), menuItem.getDescription());
        }
        System.out.println("0. 뒤로가기");
    }

}
