package com.jass;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * This is a jass class to launch a rule.
 */
public class CardGame {

    public static final void main(String[] args) {
        try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");

            // start the program!
            String playerName = Player.enterPlayerCredentials();

            DeckOfCards deck = new DeckOfCards();
            System.out.println("UnShuffeled Cards.");
            deck.showCards();
            deck.ShuffleCards();
            System.out.println("Shuffeled Cards.");
            deck.showCards();


            String playerName2 = "Yoda";
            String playerName3 = "Hagrid";
            String playerName4 = "Legolas";

            Player player1 = new Player(playerName);
            Player player2 = new Player(playerName2);
            Player player3 = new Player(playerName3);
            Player player4 = new Player(playerName4);
            // Create a deck for each player
            deck.dealCards(player1,player2,player3,player4);

            // Print one Deck for Player1
            player1.showPlayerCards();

            String trumpColour = Jass.setTrumpColour();

            ///////////////////////////////////////////////////////////////
            // Start Game and play 9 rounds
            ///////////////////////////////////////////////////////////////

            // Loop for amount of rounds to play
            for(int rounds = 1; rounds <= 9; rounds++){

                System.out.println("Starting round "+rounds);
                System.out.println("-------------------------------");

                // Show the hand of the player
                player1.showPlayerCards();
                System.out.println("Play a card of your carddeck");

                // Read in card to play
                int chosenCardNumber = Player.readInCardToPlay(player1);

                if ( chosenCardNumber == 99 ){
                    System.out.println("Invalid card chosen - please enter a valid card again");

                    chosenCardNumber = Player.readInCardToPlay(player1);
                }
                // Save cards of round into round-card array
                Card[] playedRound = new Card[3];

                // Player1
                playedRound[0] = player1.playCards[chosenCardNumber];
                // determine what cards can be played according to rules

                // Player2
                int player2CardNumber = Player.playCard(player2, trumpColour);

                System.out.println("Player 2 : " + player2.playCards[player2CardNumber-1].cardColour + " " + player2.playCards[player2CardNumber-1].cardType);
                playedRound[1] = player2.playCards[player2CardNumber-1];

                // Player3
                int player3CardNumber = Player.playCard(player3, trumpColour);

                System.out.println("Player 3 : " + player3.playCards[player3CardNumber-1].cardColour + " " + player3.playCards[player3CardNumber-1].cardType);
                playedRound[2] = player3.playCards[player3CardNumber-1];

                // Player4
                int player4CardNumber = Player.playCard(player3, trumpColour);

                System.out.println("Player 4 : " + player4.playCards[player4CardNumber-1].cardColour + " " + player4.playCards[player4CardNumber-1].cardType);
                playedRound[3] = player4.playCards[player4CardNumber-1];


                // remove played card from carddeck for all the players
                DeckOfCards.removePlayedCardFromDeck(chosenCardNumber, player1);

                DeckOfCards.removePlayedCardFromDeck(player2CardNumber, player2);

                DeckOfCards.removePlayedCardFromDeck(player3CardNumber, player3);

                DeckOfCards.removePlayedCardFromDeck(player4CardNumber, player4);

                // Assign points to cards

                // assign points




            }


            //int points = Jass.startGame(trumpColour);

            //System.out.println("You achieved " + points + " points! Congratulations!");

            Message message = new Message();
            message.setMessage("Hello World");
            message.setStatus(Message.HELLO);
            kSession.insert(message);
            kSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }


    public static class Message {

        public static final int HELLO = 0;
        public static final int GOODBYE = 1;

        private String message;

        private int status;

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getStatus() {
            return this.status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

    }

}
