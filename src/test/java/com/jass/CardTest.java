package com.jass;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
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

        int i=1;

        Card[] testset = testCards.getDeckOfCards();

        int value = Card.setCardValuesNonTrumpColour(trumpColour,testset,1);

        assertEquals(10, value);

    }

}
