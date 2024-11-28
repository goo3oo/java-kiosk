package com.example.kiosk.level3;

import java.util.*;

public class Kiosk {

    private final List<MenuItem> menuItems;  // 메뉴 항목이 담긴 리스트

    public Kiosk(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    // 키오스크 시작
    public void start() {
        // 메뉴를 반복적으로 표시
        while (true) {
            Scanner scan = new Scanner(System.in);

            System.out.println("[ SHAKE SHACK MENU ]");
            int menuNumber = 1; // 메뉴 번호로 사용, menuItem 객체에 접근할 때 마다 증가

            // 메뉴 항목들을 출력하기 위해 menuItems 리스트를 순회하며 각 메뉴의 이름, 가격, 설명을 출력
            for (MenuItem menu : menuItems) {
                // 메뉴 항목의 이름이 종료인 경우엔 "0. 종료" 표시
                if (menu.getName().equals("종료")) {
                    System.out.println("0. 종료            | " + menu.getDescription());
                } else {
                    System.out.println((menuNumber++) + ". " + menu.getName() + "\t" + "  | W " + menu.getPrice() + " | " + menu.getDescription());
                }
            }

            System.out.print("메뉴 번호를 선택하세요: ");
            int userInput = -1; // 사용자 입력값을 저장할 변수

            try {
                userInput = scan.nextInt();
            } catch (InputMismatchException e) {
                // 사용자가 입력한 값이 숫자가 아닌 경우 예외 처리
                System.out.println("숫자를 입력해주세요."); // 잘못 입력된 값을 비우기
                scan.nextLine(); // 반복문 처음으로 이동
            }


            if (userInput == 0) {
                // 사용자 입력값이 0이라면 종료
                System.out.println("종료합니다.");
                break;
            } else if (userInput >= 0 && userInput < menuNumber) {
                // 사용자 입력값이 1 이상이고 메뉴 번호 범위 내에 있을 때만 선택 처리
                selectMenu(menuItems, userInput);
            } else {
                // 오류 메시지 출력, 반복문 재시작
                System.out.println("유효한 메뉴번호가 아닙니다. 다시 입력해주세요.");
            }
        }
    }

    // 선택한 메뉴의 이름, 가격, 설명을 출력
    public static void selectMenu(List<MenuItem> menuItems, int userInput) {
        MenuItem selectedItem = menuItems.get(userInput - 1);
        System.out.print("선택한 메뉴 : ");
        System.out.println(selectedItem.getName() + ", " + selectedItem.getPrice() + ", " + selectedItem.getDescription());
    }
}