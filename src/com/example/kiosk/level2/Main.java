package com.example.kiosk.level2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // 메뉴 항목들을 저장할 리스트(menuItems) 초기화
        List<MenuItem> menuItems = new ArrayList<>();
        // MenuItem 객체들을 생성하고 menuItems 리스트에 추가
        menuItems.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
        menuItems.add(new MenuItem("종료", 0.0, "종료"));

        // 메뉴를 반복적으로 표시
        while (true) {
            System.out.println("[ SHAKE SHACK MENU ]");

            int menuNumber = 1; // 메뉴 번호로 사용, menuItem 객체에 접근할 때 마다 증가
            // 메뉴 항목들을 출력하기 위해 menuItems 리스트를 순회하며 각 메뉴의 이름, 가격, 설명을 출력
            for (MenuItem menu : menuItems) {
                if (menu.getName().equals("종료")) {
                    System.out.println("0. 종료            | " + menu.getDescription());
                } else {
                    System.out.println((menuNumber++) + ". " + menu.getName() + "\t" + "  | W " + menu.getPrice() + " | " + menu.getDescription());
                }
            }

            System.out.print("메뉴 번호를 선택하세요: ");
            int userInput; // 사용자 입력값을 저장할 변수

            try {
                userInput = scan.nextInt();
            } catch (InputMismatchException e) {
                // 사용자가 입력한 값이 숫자가 아닌 경우 예외 처리
                System.out.println("숫자를 입력해주세요.");
                scan.nextLine(); // 잘못 입력된 값을 비우기
                continue; // 반복문 처음으로 이동
            }

            if (userInput == 0) {
                // 프로그램 종료
                System.out.println("종료합니다.");
                break;
            } else if (
                // 사용자가 입력한 값이 0보다 크고, 메뉴 번호 범위 내에 있을 때 실행
                userInput > 0 && userInput < menuNumber) {
                selectMenu(menuItems, userInput);
            } else {
                // 오류 메시지 출력, 반복문 재시작
                System.out.println("유효한 메뉴번호가 아닙니다. 다시 입력해주세요.");
            }
        }

    }

    //  선택한 메뉴의 이름, 가격, 설명을 출력
    public static void selectMenu(List<MenuItem> menuItems, int number) {
        MenuItem selectedItem = menuItems.get(number-1);
        System.out.print("선택한 메뉴 : ");
        System.out.println(selectedItem.getName() + ", " + selectedItem.getPrice() + ", " + selectedItem.getDescription());
    }

}