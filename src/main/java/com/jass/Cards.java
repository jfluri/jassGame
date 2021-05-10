package com.jass;

import java.util.Arrays;

public enum Cards {
    SPADEACE("Spade", "Ace"),
    SPADEKING("Spade", "King"),
    SPADEQUEEN("Spade", "Queen"),
    SPADEJACK("Spade", "Jack"),
    SPADE10("Spade", "10"),
    SPADE9("Spade", "9"),
    SPADE8("Spade", "8"),
    SPADE7("Spade", "7"),
    SPADE6("Spade", "6"),
    CHECKACE("Check", "Ace"),
    CHECKKING("Check", "King"),
    CHECKQUEEN("Check", "Queen"),
    CHECKJACK("Check", "Jack"),
    CHECK10("Check", "10"),
    CHECK9("Check", "9"),
    CHECK8("Check", "8"),
    CHECK7("Check", "7"),
    CHECK6("Check", "6"),
    CROSSACE("Cross", "Ace"),
    CROSSKING("Cross", "King"),
    CROSSQUEEN("Cross", "Queen"),
    CROSSJACK("Cross", "Jack"),
    CROSS10("Cross", "10"),
    CROSS9("Cross", "9"),
    CROSS8("Cross", "8"),
    CROSS7("Cross", "7"),
    CROSS6("Cross", "6"),
    HEARTACE("Heart", "Ace"),
    HEARTKING("Heart", "King"),
    HEARTQUEEN("Heart", "Queen"),
    HEARTJACK("Heart", "Jack"),
    HEART10("Heart", "10"),
    HEART9("Heart", "9"),
    HEART8("Heart", "8"),
    HEART7("Heart", "7"),
    HEART6("Heart", "6");

    private final String cardColour;
    private final String cardType;

    private Cards(String cardColour, String cardType) {
        this.cardColour = cardColour;
        this.cardType = cardType;
    }

    public String getCardColour() {
        return this.cardColour;
    }

    public String cardType() {
        return this.cardType;
    }

    public static String[] getNames(Class<? extends Enum<?>> e) {
        return Arrays.stream(e.getEnumConstants()).map(Enum::name).toArray(String[]::new);
    }


}