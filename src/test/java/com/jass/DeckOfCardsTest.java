//package com.jass;
//
//import com.jass.game.DeckOfCards;
//import com.jass.game.model.Player;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.InputStream;
//import java.io.PrintStream;
//
//import static com.jass.game.DeckOfCards.enterCardToPlay;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotEquals;
//
//public class DeckOfCardsTest {
//
//    @Test
//    @DisplayName("Create and Return a Deck of Cards")
//    public void createAndReturnDeckOfCards() {
//
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        PrintStream ps = new PrintStream(baos);
//        PrintStream old = System.out;
//        System.setOut(ps);
//
//        DeckOfCards deck = new DeckOfCards();
//        deck.showCards();
//
//        System.out.flush();
//        System.setOut(old);
//        String cardDeck =  baos.toString();
//
//        String resultDeck = "---------------------------------------------\r\n" +
//                "Ace of Check     King of Check     Queen of Check     \r\n" +
//                "Jack of Check     Ten of Check     Nine of Check     \r\n" +
//                "Eight of Check     Seven of Check     Six of Check     \r\n" +
//                "Ace of Cross     King of Cross     Queen of Cross     \r\n" +
//                "Jack of Cross     Ten of Cross     Nine of Cross     \r\n" +
//                "Eight of Cross     Seven of Cross     Six of Cross     \r\n" +
//                "Ace of Heart     King of Heart     Queen of Heart     \r\n" +
//                "Jack of Heart     Ten of Heart     Nine of Heart     \r\n" +
//                "Eight of Heart     Seven of Heart     Six of Heart     \r\n" +
//                "Ace of Spade     King of Spade     Queen of Spade     \r\n" +
//                "Jack of Spade     Ten of Spade     Nine of Spade     \r\n" +
//                "Eight of Spade     Seven of Spade     Six of Spade     \r\n" +
//                "---------------------------------------------\r\n";
//
//        assertEquals(resultDeck, cardDeck);
//    }
//
//    @Test
//    @DisplayName("Shuffle a Deck of Cards")
//    public void shuffleDeckOfCards() {
//
//        String originalResultDeck = "---------------------------------------------\r\n" +
//                "Ace of Check     King of Check     Queen of Check     \r\n" +
//                "Jack of Check     Ten of Check     Nine of Check     \r\n" +
//                "Eight of Check     Seven of Check     Six of Check     \r\n" +
//                "Ace of Cross     King of Cross     Queen of Cross     \r\n" +
//                "Jack of Cross     Ten of Cross     Nine of Cross     \r\n" +
//                "Eight of Cross     Seven of Cross     Six of Cross     \r\n" +
//                "Ace of Heart     King of Heart     Queen of Heart     \r\n" +
//                "Jack of Heart     Ten of Heart     Nine of Heart     \r\n" +
//                "Eight of Heart     Seven of Heart     Six of Heart     \r\n" +
//                "Ace of Spade     King of Spade     Queen of Spade     \r\n" +
//                "Jack of Spade     Ten of Spade     Nine of Spade     \r\n" +
//                "Eight of Spade     Seven of Spade     Six of Spade     \r\n" +
//                "---------------------------------------------\r\n";
//
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        PrintStream ps = new PrintStream(baos);
//        PrintStream old = System.out;
//        System.setOut(ps);
//
//        DeckOfCards deck = new DeckOfCards();
//        deck.shuffleCards();
//        deck.showCards();
//
//        System.out.flush();
//        System.setOut(old);
//        String cardDeck =  baos.toString();
//
//        assertNotEquals(originalResultDeck,cardDeck);
//    }
//
//    @Test
//    @DisplayName("Test if Card can be entered to play")
//    public void testEnterCardToPlay(){
//
//        DeckOfCards testDeck = new DeckOfCards();
//
//        Player player1 = new Player("Jasmin");
//        Player player2 = new Player("Dodo");
//        Player player3 = new Player("Dodo");
//        Player player4 = new Player("Dodo");
//        // Create a deck for each player
//        testDeck.dealCards(player1,player2,player3,player4);
//
//        // Print one Deck for Player1
//        player1.showPlayerCards();
//
//        String input = "0";
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//        int chosenCard = enterCardToPlay(player1);
//
//        String input2 = "3";
//        InputStream in2 = new ByteArrayInputStream(input2.getBytes());
//        System.setIn(in2);
//        int chosenCard2 = enterCardToPlay(player1);
//
//        String input3 = "9";
//        InputStream in3 = new ByteArrayInputStream(input3.getBytes());
//        System.setIn(in3);
//        int chosenCard3 = enterCardToPlay(player1);
//
//        Assertions.assertAll(
//                () -> assertEquals(0, chosenCard),
//                () -> assertEquals(3, chosenCard2 ),
//                () -> assertEquals(99, chosenCard3)
//        );
//
//    }
//
//    @Test
//    @DisplayName("Test if Card is removed from Deck")
//    public void testRemoveCardFromDeck(){
//
//        DeckOfCards testDeck = new DeckOfCards();
//
//        Player player1 = new Player("Jasmin");
//        Player player2 = new Player("Dodo");
//        Player player3 = new Player("Dodo");
//        Player player4 = new Player("Dodo");
//        // Create a deck for each player
//        testDeck.dealCards(player1,player2,player3,player4);
//
//
//        DeckOfCards.removePlayedCardFromDeck(0, player1);
//        DeckOfCards.removePlayedCardFromDeck(0, player1);
//
//        int amtCardsInDeck = player1.playCards.length;
//
//        Assertions.assertAll(
//                () -> assertEquals(7, amtCardsInDeck)
//        );
//
//    }
//
//
//}
