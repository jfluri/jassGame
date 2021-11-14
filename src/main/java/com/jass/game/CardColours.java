package com.jass.game;

public enum CardColours {
    HEART("Heart","❤❤❤"),
    SPADE("Spade","♠♠♠"),
    CROSS("Cross","♣♣♣"),
    CHECK("Check","♦♦♦");

    private final String cardColour;
    private final String cardSymbol;

    CardColours(String cardColour, String cardSymbol) {
        this.cardColour = cardColour;
        this.cardSymbol = cardSymbol;
    }

    public String getCardColour() {
        return cardColour;
    }

    public String cardSymbol() {
        return cardSymbol;
    }
}
