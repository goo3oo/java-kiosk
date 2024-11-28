package com.example.kiosk.levelChallenge2;

public enum DiscountRate {
    // 할인 유형을 정의한 이넘클래스
    NATIONALMERIT(1,"국가유공자","10%",0.9),
    MILITARYPERSONNEL(2,"군인","5%", 0.95),
    STUDENT(3,"학생","3%",0.97),
    NORMAL(4,"일반","0%",1);

    private final int order; // 번호
    private final String discountCategory; // 할인 유형의 분류
    private final String discountRate; // 할인 유형 별 할인율
    private final double discount; // 할인 유형 별 할인된 가격

    DiscountRate(int order, String discountCategory, String discountRate, double discount){
        this.order = order;
        this.discountCategory = discountCategory;
        this.discountRate = discountRate;
        this.discount = discount;
    }

    /**
     * 사용자 입력에 따라 할인 유형을 반환하는 메서드
     * 사용자가 입력한 번호에 맞는 DiscountRate 객체를 반환
     *
     * @param userInput : 사용자에게 입력받은 할인 유형 번호
     * @return : 입력 값에 해당하는 할인 유형 객체
     * @throws IllegalArgumentException : 유효하지 않은 번호가 입력되었을 경우 발생
     */
    public static DiscountRate toEnum(int userInput) {
        for (DiscountRate d : DiscountRate.values()) {
            if (d.order == userInput) {
                return d;
            }
        }
        // 유효하지 않은 번호가 입력될 경우 예외 발생
        throw new IllegalArgumentException("유효하지 않은 연산자:" + userInput);
    }

    public int getOrder(){
        return order;
    }

    public String getDiscountCategory(){
        return discountCategory;
    }

    public String getDiscountRate(){
        return discountRate;
    }

    public double getDiscount(){
        return discount;
    }
}
