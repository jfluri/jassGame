package com.jass;

public enum CardTypes {
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

    private CardTypes(String cardType) {
        this.cardType = cardType;
    }

    public String getCardType() {
        return cardType;
    }


}
