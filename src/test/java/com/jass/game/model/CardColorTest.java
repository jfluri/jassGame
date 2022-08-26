package com.jass.game.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardColorTest {

    @Test
    @DisplayName("Test Getter of Card Symbols")
    public void testGetCardSymbols() {
        assertEquals("❤❤❤", CardColor.HEART.cardSymbol());
        assertEquals("♠♠♠", CardColor.SPADE.cardSymbol());
        assertEquals("♣♣♣", CardColor.CROSS.cardSymbol());
        assertEquals("♦♦♦", CardColor.CHECK.cardSymbol());
    }
}
