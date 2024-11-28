package com.example.kiosk.level4;

import java.util.*;

public class Kiosk {

    private final Scanner scan = new Scanner(System.in);
    private final List<Menu> menu; // 메뉴항목이 담긴 리스트들을 저장한 카테고리 리스트

    // 생성자  메뉴항목이 담긴 리스트들을 저장한 카테고리 리스트 주입
    public Kiosk(List<Menu> menu) {
        this.menu = menu;
    }

    public void start() {
        while (true) {
            printMainMenu(); // 카테고리 메뉴를 출력하는 메인메뉴 화면 출력
            // 첫 번째로 입력받은 값은 mainInput 변수에 저장
            int mainInput = getValidInput(); // 사용자 입력값이 숫자가 맞는지 체크 후 맞으면 사용자 입력 값 할당

            if (mainInput == 0) {
                //vm
                System.out.println("종료합니다.");
                return;
            } else if (mainInput > 0 && mainInput <= menu.size()) {
                // mainInput 번호가 카테고리 번호 범위 안에 있을 때 실행
                printSubMenu(mainInput);  // 입력받은 카테고리 번호와 일치하는 카테고리 내의 메뉴항목들 출력
                // 두 번째로 입력받은 값은 subInput 변수에 저장
                int subInput = getValidInput(); // 사용자 입력값이 숫자가 맞는지 체크 후 맞으면 사용자 입력 값 할당
                if (subInput == 0) {
                    continue; //뒤로가기
                } else if (subInput > 0 && subInput <= menu.get(mainInput - 1).getMenuItems().size()) {
                    // 선택한 메뉴 출력
                    MenuItem menuItem = menu.get(mainInput - 1).getMenuItems().get(subInput - 1);
                    System.out.printf("선택한 메뉴 : %-10s | W %-3.1f | %s%n", menuItem.getName(), menuItem.getPrice(), menuItem.getDescription());
                } else {
                    // 오류 메시지 출력, 반복문 재 시작
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

    /**
     * 사용자 입력값을 받고, 숫자가 맞는지 검사한 후 숫자 입력값 반환
     * @return 숫자인 사용자 입력값
     */
    public int getValidInput() {
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
    /**
     * mainMenu 출력
     * 메뉴 리스트의 카테고리 출력
     */
    public void printMainMenu() {
        System.out.println("[ MAIN MENU ]");

        int menuNumber = 1;
        for (Menu menu1 : menu) {
            System.out.println((menuNumber++) + ". " + menu1.getCategoryName());
        }
        System.out.println("0. 종료");
    }
    /**
     * subMenu 출력
     * 사용자 입력값에 따른 카테고리 내의 메뉴 항목들 출력
     */
    public void printSubMenu(int userInput) {
        Menu selectedMenu = menu.get(userInput - 1);
        System.out.println("[ " + selectedMenu.getCategoryName().toUpperCase() + " MENU ]");

        int menuNumber = 1;
        for (MenuItem menuItem : selectedMenu.getMenuItems()) {
            System.out.printf("%-1d. %-20s | W %-4.1f | %s%n", menuNumber++, menuItem.getName(), menuItem.getPrice(), menuItem.getDescription());
        }
        System.out.println("0. 뒤로가기");
    }

}
