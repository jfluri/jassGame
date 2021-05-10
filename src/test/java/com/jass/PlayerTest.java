package com.jass;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @Test
    @DisplayName("Save and return Player Name")
    public void enterPlayerCredentialsTest() {

        String input = "Jasmin";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String playerName = Player.enterPlayerCredentials();

        assertEquals(input, playerName);
    }

    @Test
    @DisplayName("Save and return an Empty Player Name")
    public void enterEmptyPlayerCredentialsTest() {

        String input = "";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String playerName = Player.enterPlayerCredentials();

        assertEquals("CleverLlama", playerName);
    }

    @Test
    @DisplayName("Test Player Constructor")
    public void testPlayerConstructor(){

        Player testPlayer = new Player("Jasmin");

        assertEquals("Jasmin", Player.getName());

    }

    @Test
    @DisplayName("Test Show Cards of Player")
    public void testShowCardsOfPlayer(){


        String resultHand = "---------------------------------------------\r\n" +
                "Ace  of  Spade\r\n" +
                "King  of  Spade\r\n" +
                "Queen  of  Spade\r\n" +
                "Jack  of  Spade\r\n" +
                "Ten  of  Spade\r\n" +
                "Nine  of  Spade\r\n" +
                "Eight  of  Spade\r\n" +
                "Seven  of  Spade\r\n" +
                "Six  of  Spade\r\n" +
                "---------------------------------------------\r\n";

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);

        DeckOfCards testDeck = new DeckOfCards();
        //testDeck.ShuffleCards();

        Player player1 = new Player("Jasmin");
        Player player2 = new Player("Dodo");
        Player player3 = new Player("Dodo");
        Player player4 = new Player("Dodo");
        // Create a deck for each player
        testDeck.dealCards(player1,player2,player3,player4);

        // Print one Deck for Player1
        player1.showPlayerCards();

        System.out.flush();
        System.setOut(old);
        String playerHand =  baos.toString();

        assertEquals(resultHand,playerHand);


    }

}
