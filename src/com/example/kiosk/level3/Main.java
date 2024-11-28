package com.example.kiosk.level3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // MenuItem 객체들을 저장할 리스트(menuItems) 초기화
        List<MenuItem> menuItems = new ArrayList<>();
        // MenuItem 객체들을 생성하고 menuItems 리스트에 추가
        menuItems.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
        menuItems.add(new MenuItem("종료", 0.0, "종료"));
        // 키오스크에 MenuItem 객체들이 저장된 리스트(menuItems) 주입
        Kiosk kiosk = new Kiosk(menuItems);
        // 키오스크 실행
        kiosk.start();
    }
}