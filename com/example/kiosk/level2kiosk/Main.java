package com.example.kiosk.level2kiosk;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<MenuItem> menuItems = new ArrayList<>();

        menuItems.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack",8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger",6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger",5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
        menuItems.add(new MenuItem("종료", 0.0, "종료"));

        while (true) {
            System.out.println("[ SHAKE SHACK MENU ]");
            int menuNumber=1;
            for(MenuItem menu : menuItems){
                if(menu.getBurgerName().equals("종료")) {
                    System.out.println("0. 종료            | "+ menu.getDescription());
                }else{
                    System.out.println((menuNumber++) + ". " + menu.getBurgerName() + "\t" + "  | W " + menu.getBurgerPrice() + " | " + menu.getDescription());
                }
            }

            while(true){
            try {
                menuNumber = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력해주세요.");
                scan.nextLine();
                continue;
            }
                switch (menuNumber) {
                    case 0:
                        System.out.println("프로그램을 종료합니다.");
                        return;
                    case 1:
                        selectMenu(menuItems, 0);
                        break;
                    case 2:
                        selectMenu(menuItems, 1);
                        break;
                    case 3:
                        selectMenu(menuItems, 2);
                        break;
                    case 4:
                        selectMenu(menuItems, 3);
                        break;
                    default:
                        System.out.println("유효하지 않은 숫자입니다.");
                }
            }
        }
    }
    public static void selectMenu(List<MenuItem> menuItems, int number) {
        MenuItem selectedItem = menuItems.get(number);
        System.out.print("선택한 메뉴 : ");
        System.out.println(selectedItem.getBurgerName()+", "+selectedItem.getBurgerPrice()+", "+selectedItem.getDescription());
    }
}
