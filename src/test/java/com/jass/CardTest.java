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

        int i=5; //NINE
        int j=0; //ACE

        Card[] testset = testCards.getDeckOfCards();

        Assertions.assertAll(
                () -> assertEquals(0, Card.setCardValuesNonTrumpColour(trumpColour,testset,i)),
                () -> assertEquals(11, Card.setCardValuesNonTrumpColour(trumpColour,testset,j))
        );

    }

    @Test
    @DisplayName("Test if values are assigned to trump colours")
    public void testValueAssignmentTrumpColours(){

        String trumpColour = "Check";
        DeckOfCards testCardsT = new DeckOfCards();

        Player player1 = new Player("Jasmin");
        Player player2 = new Player("Dodo");
        Player player3 = new Player("Dodo");
        Player player4 = new Player("Dodo");
        // Create a deck for each player
        testCardsT.dealCards(player1,player2,player3,player4);

        int i=5; //NINE
        int j=0; //ACE

        Card[] testset2 = testCardsT.getDeckOfCards();

        Assertions.assertAll(
                () -> assertEquals(9, Card.setCardValuesTrumpColour(trumpColour,testset2,i)),
                () -> assertEquals(11, Card.setCardValuesTrumpColour(trumpColour,testset2,j))
        );
    }

}
