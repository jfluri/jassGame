package com.jass.game.model;


public class Card {

    private final CardColor cardColor;
    private final CardType cardType;
    private final CardColor trumpColor;

    private int point;

    public Card(final CardColor cardColor, final CardType cardType, final CardColor trumpColour) {
        this.cardColor = cardColor;
        this.cardType = cardType;
        this.trumpColor = trumpColour;
    }

    public static Card of( final CardColor cardColor,  final CardType cardType) {
        return new Card(cardColor, cardType, null);
    }

    public String getCardId() {
        return cardType.getCardType() + "_" + cardColor.getCardColor();
    }

    public CardType getCardType() {
        return cardType;
    }

    public CardColor getCardColor() {
        return cardColor;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(final int point) {
        this.point = point;
    }

    public boolean isTrumpColor() {
        return cardColor.equals(trumpColor);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (getCardColor() != card.getCardColor()) return false;
        return getCardType() == card.getCardType();
    }

    @Override
    public int hashCode() {
        int result = getCardColor().hashCode();
        result = 31 * result + getCardType().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return cardType.getCardType() + " of " + cardColor.getCardColor() + "     ";
    }
}
