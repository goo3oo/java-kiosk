package com.example.kiosk.levelChallenge2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<MenuItem> burgers = new ArrayList<>();
        setItems(burgers,"Hamburger",13.4,"부드러운 참깨 번 사이에 갓 구운 신선한 수제 패티 2장을 얹어 제공합니다. 토핑은 자유롭게 선택해보세요.");
        setItems(burgers,"Cheeseburger",14.9,"부드러운 참깨 번 사이에 아메리칸 스타일 치즈를 녹여 넣은 수제 패티 2장을 얹어 제공합니다. 토핑은 자유롭게 선택해보세요.");
        setItems(burgers,"Bacon Burger",15.9,"부드러운 참깨 번 사이에 바삭한 애플우드 베이컨과 수제 패티 2장을 얹어 제공합니다. 토핑은 자유롭게 선택해보세요.");
        setItems(burgers,"Bacon Cheeseburger",17.4,"부드러운 참깨 번 사이에 바삭한 애플우드 베이컨과 아메리칸 스타일 치즈를 녹여 넣은 수제 패티 2장을 얹어 제공합니다. 토핑은 자유롭게 선택해보세요.");

        List<MenuItem> fries = new ArrayList<>();
        setItems(fries, "Five guys / Little", 6.9,"100% 땅콩 기름을 이용해 갓 튀겨낸 보드워크 스타일(Boardwalk-style) 감자튀김");
        setItems(fries, "Five guys / Regular", 8.9,"100% 땅콩 기름을 이용해 갓 튀겨낸 보드워크 스타일(Boardwalk-style) 감자튀김");
        setItems(fries, "Five guys / Large", 10.9,"100% 땅콩 기름을 이용해 갓 튀겨낸 보드워크 스타일(Boardwalk-style) 감자튀김");
        setItems(fries, "Cajun  / Little", 6.9,"100% 땅콩 기름을 이용해 튀겨낸 뒤 케이준 시즈닝을 듬뿍 뿌려 제공하는 보드워크 스타일(Boardwalk-style) 감자튀김");
        setItems(fries, "Cajun  / Regular", 8.9,"100% 땅콩 기름을 이용해 튀겨낸 뒤 케이준 시즈닝을 듬뿍 뿌려 제공하는 보드워크 스타일(Boardwalk-style) 감자튀김");
        setItems(fries, "Cajun  / Large", 10.9,"100% 땅콩 기름을 이용해 튀겨낸 뒤 케이준 시즈닝을 듬뿍 뿌려 제공하는 보드워크 스타일(Boardwalk-style) 감자튀김");

        List<MenuItem> drinks = new ArrayList<>();
        setItems(drinks,"Soda", 3.6, "탄산음료");
        setItems(drinks,"Water", 5.2, "생수 500ml");
        setItems(drinks,"Seegram", 4.5, "씨그램 350ml");
        setItems(drinks,"Budweiser", 4.7, "버드와이저");
        setItems(drinks,"Stella Artois", 5.0, "스텔라 아르투아");
        setItems(drinks,"Goose Island IPA", 4.0, "구스 아일랜드 IPA");

        List<MenuItem> milkshakes = new ArrayList<>();
        setItems(milkshakes,"Chocolate", 8.9, "초콜릿과 퍼지를 더한 수제 밀크쉐이크입니다");
        setItems(milkshakes,"Peanut Butter", 8.9, "크리미한 천연 피넛 버터와 약간의 꿀을 더한 밀크쉐이크입니다.");
        setItems(milkshakes,"Salted Caramel", 8.9, "달콤 짭짤한 카라멜이 들어간 밀크쉐이크입니다.");
        setItems(milkshakes,"Bacon", 8.9, "달콤한 애플우드 베이컨을 잘게 썰어 넣어 바삭함과 짭짤함을 더한 밀크쉐이크입니다.");
        setItems(milkshakes,"Bananas", 8.9, "생 바나나가 들어 있는 수제 밀크쉐이크입니다.");
        setItems(milkshakes,"Strawberries", 8.9, "신선한 딸기로 매장에서 직접 만든 홈메이드 시럽을 더한 밀크쉐이크입니다.");

        List<Menu> menu = new ArrayList<>();
        menu.add(new Menu(burgers,"burgers"));
        menu.add(new Menu(fries,"fries"));
        menu.add(new Menu(drinks,"drinks"));
        menu.add(new Menu(milkshakes,"milkshakes"));

        CartManager cartManager = new CartManager();
        Kiosk kiosk = new Kiosk(menu, cartManager);
        kiosk.start();
    }

    private static void setItems(List<MenuItem> menuItem, String name, double price, String description){
        menuItem.add(new MenuItem(name, price, description));
    }
}
