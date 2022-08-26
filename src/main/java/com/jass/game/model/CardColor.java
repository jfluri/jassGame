package com.jass.game.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum CardColor {
    HEART("Heart", "❤❤❤"),
    SPADE("Spade", "♠♠♠"),
    CROSS("Cross", "♣♣♣"),
    CHECK("Check", "♦♦♦");

    private final String cardColor;
    private final String cardSymbol;

    CardColor(final String cardColor, final String cardSymbol) {
        this.cardColor = cardColor;
        this.cardSymbol = cardSymbol;
    }

    public String getCardColor() {
        return cardColor;
    }

    public String cardSymbol() {
        return cardSymbol;
    }

    @Override
    public String toString() {
        return cardColor + " " +  cardSymbol;
    }

    public static List<String> getCardColors() {
        return Arrays.stream(values()).map(CardColor::getCardColor).collect(Collectors.toList());
    }

    public static CardColor getByCardColor(final String color) {
        for (final CardColor cardColor : values()) {
            if (cardColor.getCardColor().equalsIgnoreCase(color)) {
                return cardColor;
            }
        }
        return null;
    }
}
