package com.jass.game;

import com.jass.game.model.Card;
import com.jass.game.model.CardColor;
import com.jass.game.model.CardType;

import java.util.Random;

public class DeckOfCards {

    private final Card[] deckOfCards = new Card[36];

    public DeckOfCards(final CardColor trumpColour) {
        int count = 0;

        for (final CardColor cardColor : CardColor.values()) {
            for (final CardType cardType : CardType.values()) {
                final Card card = new Card(cardColor, cardType, trumpColour);
                this.deckOfCards[count++] = card;
            }
        }
    }

    public Card[] getDeckOfCards() {
        return this.deckOfCards;
    }

    public void shuffleCards() {
        final Random rand = new Random();
        for (int i = 0; i < deckOfCards.length; i++) {
            final int j = rand.nextInt(deckOfCards.length);
            final Card temp = deckOfCards[i];
            deckOfCards[i] = deckOfCards[j];
            deckOfCards[j] = temp;
        }
    }

    public void showCards() {
        System.out.println("---------------------------------------------");
        int count = 0;
        for (final Card card : deckOfCards) {
            System.out.print(card);
            count++;
            if (count % 3 == 0) {
                System.out.println();
            }
        }
        System.out.println("---------------------------------------------");
    }
}
