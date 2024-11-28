package com.example.kiosk.levelChallenge2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputValidator {
    // 사용자로부터 값을 입력받고, 입력의 유효성을 검사하는 클래스
    private final Scanner scan = new Scanner(System.in);

    /**
     * 사용자로부터 유효한 메뉴 번호를 입력받는 메서드
     * 유효한 값이 입력될 때 까지 반복
     * @param size : 유효한 입력 범위의 상한 (0부터 size 까지의 값만 허용)
     * @return : 유효한 사용자 입력
     */
    public int getValidInput(int size) {
        int input;
        while (true) {
            try {
                input = scan.nextInt(); // 사용자 입력 받기
                if (input >= 0 && input <= size) {
                    return input; // 유효한 입력 반환
                } else {
                    System.out.println("유효하지 않은 메뉴 번호입니다. 다시 입력해주세요.");
                }
            } catch (InputMismatchException e) {
                // 사용자 입력이 숫자가 아닌 경우 예외 처리
                System.out.println("메뉴 번호를 입력해주세요.");
                scan.nextLine(); // 잘못된 입력을 버리고 새로 입력 받기
            }
        }
    }
}
