package com.jass;

import com.jass.game.CardColours;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardColoursTest {

    @Test
    @DisplayName("Test Getter of Card Symbols")
    public void testGetCardSymbols() {

        assertEquals("❤❤❤", CardColours.HEART.cardSymbol());
    }

}
