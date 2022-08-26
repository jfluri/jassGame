package com.jass.game.model;

public enum CardType {
    ACE("Ace"),
    KING("King"),
    QUEEN("Queen"),
    JACK("Jack"),
    TEN("Ten"),
    NINE("Nine"),
    EIGHT("Eight"),
    SEVEN("Seven"),
    SIX("Six");

    private final String cardType;

    CardType(final String cardType) {
        this.cardType = cardType;
    }

    public String getCardType() {
        return cardType;
    }
}