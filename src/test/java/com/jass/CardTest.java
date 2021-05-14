package com.jass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class CardTest {

    @Test
    @DisplayName("Test if values are assigned to non trump colours")
    public void testValueAssignmentNonTrumpColours(){

        String trumpColour = "HEART";
        DeckOfCards testCards = new DeckOfCards();

        Player player1 = new Player("Jasmin");
        Player player2 = new Player("Dodo");
        Player player3 = new Player("Dodo");
        Player player4 = new Player("Dodo");
        // Create a deck for each player
        testCards.dealCards(player1,player2,player3,player4);

        int six = 8; // SIX
        int seven = 7; // SEVEN
        int eight = 6; // EIGHT
        int nine = 5; //NINE
        int ten = 4; // TEN
        int jack = 3; //JACK
        int queen = 2; // QUEEN
        int king = 1; //KING
        int ace = 0; //ACE

        Card[] testset = testCards.getDeckOfCards();

        Assertions.assertAll(
                () -> assertEquals(0, Card.setCardValue(trumpColour,testset,six)),
                () -> assertEquals(0, Card.setCardValue(trumpColour,testset,seven)),
                () -> assertEquals(0, Card.setCardValue(trumpColour,testset,eight)),
                () -> assertEquals(0, Card.setCardValue(trumpColour,testset,nine)),
                () -> assertEquals(10, Card.setCardValue(trumpColour,testset,ten)),
                () -> assertEquals(2, Card.setCardValue(trumpColour,testset,jack)),
                () -> assertEquals(3, Card.setCardValue(trumpColour,testset,queen)),
                () -> assertEquals(4, Card.setCardValue(trumpColour,testset,king)),
                () -> assertEquals(11, Card.setCardValue(trumpColour,testset,ace))
        );

    }

    @Test
    @DisplayName("Test if values are assigned to trump colours")
    public void testValueAssignmentTrumpColours(){

        String trumpColour = "CHECK";
        DeckOfCards testCards = new DeckOfCards();

        Player player1 = new Player("Jasmin");
        Player player2 = new Player("Dodo");
        Player player3 = new Player("Dodo");
        Player player4 = new Player("Dodo");
        // Create a deck for each player
        testCards.dealCards(player1,player2,player3,player4);

        int six = 8; // SIX
        int seven = 7; // SEVEN
        int eight = 6; // EIGHT
        int nine = 5; //NINE
        int ten = 4; // TEN
        int jack = 3; //JACK
        int queen = 2; // QUEEN
        int king = 1; //KING
        int ace = 0; //ACE

        Card[] testset = testCards.getDeckOfCards();

        Assertions.assertAll(
                () -> assertEquals(0, Card.setCardValue(trumpColour,testset,six)),
                () -> assertEquals(0, Card.setCardValue(trumpColour,testset,seven)),
                () -> assertEquals(0, Card.setCardValue(trumpColour,testset,eight)),
                () -> assertEquals(14, Card.setCardValue(trumpColour,testset,nine)),
                () -> assertEquals(10, Card.setCardValue(trumpColour,testset,ten)),
                () -> assertEquals(20, Card.setCardValue(trumpColour,testset,jack)),
                () -> assertEquals(3, Card.setCardValue(trumpColour,testset,queen)),
                () -> assertEquals(4, Card.setCardValue(trumpColour,testset,king)),
                () -> assertEquals(11, Card.setCardValue(trumpColour,testset,ace))
        );

    }


}
