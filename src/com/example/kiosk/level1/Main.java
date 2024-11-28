package com.example.kiosk.level1;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // 메뉴 항목들을 저장할 리스트 초기화
        List<String> menu = new ArrayList<>();
        menu.add("ShackBurger   | W 6.9 |  토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        menu.add("SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        menu.add("Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        menu.add("Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거");

        // 메뉴를 반복적으로 표시
        while (true) {
            System.out.println("[ SHAKE SHACK MENU ]");
            for (int i = 0; i < menu.size(); i++) {
                System.out.println((i + 1) + ". " + menu.get(i));
            }
            System.out.println("0. 종료 | 종료");

            int menuNumber; // 사용자 입력값을 저장할 변수


            try {
                menuNumber = scan.nextInt();
            } catch (InputMismatchException e) {
                // 숫자가 아닌 값이 들어왔을 때 처리
                System.out.println("유효한 숫자를 입력해주세요.");
                scan.nextLine(); // 잘못 입력된 값을 비우기
                continue; //반복문 처음으로 이동
            }

            //사용자 입력값에 따른 분기
            switch (menuNumber) {
                case 0:
                    //프로그램 종료
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    //잘못된 숫자가 입력된 경우
                    System.out.println("유효하지 않은 숫자입니다.");
            }
        }
    }
}