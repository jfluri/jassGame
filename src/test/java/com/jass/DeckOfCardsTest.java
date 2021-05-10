package com.jass;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DeckOfCardsTest {

    @Test
    @DisplayName("Create and Return a Deck of Cards")
    public void createAndReturnDeckOfCards() {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);

        DeckOfCards deck = new DeckOfCards();
        deck.showCards();

        System.out.flush();
        System.setOut(old);
        String cardDeck =  baos.toString();

        String resultDeck = "---------------------------------------------\r\n" +
                "Ace of Check     King of Check     Queen of Check     \r\n" +
                "Jack of Check     Ten of Check     Nine of Check     \r\n" +
                "Eight of Check     Seven of Check     Six of Check     \r\n" +
                "Ace of Cross     King of Cross     Queen of Cross     \r\n" +
                "Jack of Cross     Ten of Cross     Nine of Cross     \r\n" +
                "Eight of Cross     Seven of Cross     Six of Cross     \r\n" +
                "Ace of Heart     King of Heart     Queen of Heart     \r\n" +
                "Jack of Heart     Ten of Heart     Nine of Heart     \r\n" +
                "Eight of Heart     Seven of Heart     Six of Heart     \r\n" +
                "Ace of Spade     King of Spade     Queen of Spade     \r\n" +
                "Jack of Spade     Ten of Spade     Nine of Spade     \r\n" +
                "Eight of Spade     Seven of Spade     Six of Spade     \r\n" +
                "---------------------------------------------\r\n";

        assertEquals(resultDeck, cardDeck);
    }

    @Test
    @DisplayName("Shuffle a Deck of Cards")
    public void shuffleDeckOfCards() {

        String originalResultDeck = "---------------------------------------------\r\n" +
                "Ace of Check     King of Check     Queen of Check     \r\n" +
                "Jack of Check     Ten of Check     Nine of Check     \r\n" +
                "Eight of Check     Seven of Check     Six of Check     \r\n" +
                "Ace of Cross     King of Cross     Queen of Cross     \r\n" +
                "Jack of Cross     Ten of Cross     Nine of Cross     \r\n" +
                "Eight of Cross     Seven of Cross     Six of Cross     \r\n" +
                "Ace of Heart     King of Heart     Queen of Heart     \r\n" +
                "Jack of Heart     Ten of Heart     Nine of Heart     \r\n" +
                "Eight of Heart     Seven of Heart     Six of Heart     \r\n" +
                "Ace of Spade     King of Spade     Queen of Spade     \r\n" +
                "Jack of Spade     Ten of Spade     Nine of Spade     \r\n" +
                "Eight of Spade     Seven of Spade     Six of Spade     \r\n" +
                "---------------------------------------------\r\n";

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);

        DeckOfCards deck = new DeckOfCards();
        deck.ShuffleCards();
        deck.showCards();

        System.out.flush();
        System.setOut(old);
        String cardDeck =  baos.toString();

        assertNotEquals(originalResultDeck,cardDeck);
    }


}
