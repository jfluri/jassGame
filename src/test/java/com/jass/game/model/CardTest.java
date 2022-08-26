//package com.jass.game.model;
//
//import com.jass.game.model.Card;
//import com.jass.game.DeckOfCards;
//import com.jass.game.model.Player;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//public class CardTest {
//
//    @Test
//    @DisplayName("Test if values are assigned to non trump colours")
//    public void testValueAssignmentNonTrumpColours(){
//
//        String trumpColour = "HEART";
//        DeckOfCards testCards = new DeckOfCards();
//
//        Player player1 = new Player("Jasmin", 1);
//        Player player2 = new Player("Dodo", 2);
//        Player player3 = new Player("Dodo", 3);
//        Player player4 = new Player("Dodo", 4);
//        // Create a deck for each player
//        testCards.dealCards(player1,player2,player3,player4);
//
//        int six = 8; // SIX
//        int seven = 7; // SEVEN
//        int eight = 6; // EIGHT
//        int nine = 5; //NINE
//        int ten = 4; // TEN
//        int jack = 3; //JACK
//        int queen = 2; // QUEEN
//        int king = 1; //KING
//        int ace = 0; //ACE
//
//        Card[] testset = testCards.getDeckOfCards();
//
//        Assertions.assertAll(
//                () -> assertEquals(0, Card.getCardValue(trumpColour,testset,six)),
//                () -> assertEquals(0, Card.getCardValue(trumpColour,testset,seven)),
//                () -> assertEquals(0, Card.getCardValue(trumpColour,testset,eight)),
//                () -> assertEquals(0, Card.getCardValue(trumpColour,testset,nine)),
//                () -> assertEquals(10, Card.getCardValue(trumpColour,testset,ten)),
//                () -> assertEquals(2, Card.getCardValue(trumpColour,testset,jack)),
//                () -> assertEquals(3, Card.getCardValue(trumpColour,testset,queen)),
//                () -> assertEquals(4, Card.getCardValue(trumpColour,testset,king)),
//                () -> assertEquals(11, Card.getCardValue(trumpColour,testset,ace))
//        );
//
//    }
//
//    @Test
//    @DisplayName("Test if values are assigned to trump colours")
//    public void testValueAssignmentTrumpColours(){
//
//        String trumpColour = "CHECK";
//        DeckOfCards testCards = new DeckOfCards();
//
//        Player player1 = new Player("Jasmin");
//        Player player2 = new Player("Dodo");
//        Player player3 = new Player("Dodo");
//        Player player4 = new Player("Dodo");
//        // Create a deck for each player
//        testCards.dealCards(player1,player2,player3,player4);
//
//        int six = 8; // SIX
//        int seven = 7; // SEVEN
//        int eight = 6; // EIGHT
//        int nine = 5; //NINE
//        int ten = 4; // TEN
//        int jack = 3; //JACK
//        int queen = 2; // QUEEN
//        int king = 1; //KING
//        int ace = 0; //ACE
//
//        Card[] testset = testCards.getDeckOfCards();
//
//        Assertions.assertAll(
//                () -> assertEquals(0, Card.getCardValue(trumpColour,testset,six)),
//                () -> assertEquals(0, Card.getCardValue(trumpColour,testset,seven)),
//                () -> assertEquals(0, Card.getCardValue(trumpColour,testset,eight)),
//                () -> assertEquals(14, Card.getCardValue(trumpColour,testset,nine)),
//                () -> assertEquals(10, Card.getCardValue(trumpColour,testset,ten)),
//                () -> assertEquals(20, Card.getCardValue(trumpColour,testset,jack)),
//                () -> assertEquals(3, Card.getCardValue(trumpColour,testset,queen)),
//                () -> assertEquals(4, Card.getCardValue(trumpColour,testset,king)),
//                () -> assertEquals(11, Card.getCardValue(trumpColour,testset,ace))
//        );
//
//    }
//
//
//}
