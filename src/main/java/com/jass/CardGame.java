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


            // Assign points to cards

            // Start Game and play 9 rounds

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
