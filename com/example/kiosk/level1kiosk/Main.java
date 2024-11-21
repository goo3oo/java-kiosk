package com.example.kiosk.level1kiosk;

import java.util.*;

public class Main {
    //사용자 입력 (Scanner), 메뉴 선택(조건문), 계속 메뉴화면 출력(반복문)
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> menu = new ArrayList<>();
        menu.add("ShackBurger   | W 6.9 |  토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        menu.add("SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        menu.add("Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        menu.add("Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거");

        while (true) {
            System.out.println("[ SHAKE SHACK MENU ]");
            for (int i = 0; i < menu.size(); i++) {
                System.out.println((i + 1) + ". " + menu.get(i));
            }
            System.out.println("0. 종료 | 종료");

            int menuNumber;

            try {
                menuNumber = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("유효한 숫자를 입력해주세요.");
                scan.nextLine();
                continue;
            }
            switch (menuNumber) {
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("유효하지 않은 숫자입니다.");
            }
        }
    }
}

