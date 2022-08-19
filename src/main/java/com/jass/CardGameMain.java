package com.jass;

import com.jass.cli.CardUtils;
import com.jass.cli.PlayerUtils;
import com.jass.game.CardColours;
import com.jass.game.JassGame;
import com.jass.game.Player;
import org.kie.api.KieServices;
import org.kie.api.event.rule.DebugAgendaEventListener;
import org.kie.api.event.rule.DebugRuleRuntimeEventListener;
import org.kie.api.logger.KieRuntimeLogger;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a com class to launch a rule.
 */
public class CardGameMain {

    public static final void main(String[] args) {
        try {
            // load up the knowledge base
	        //KieServices ks = KieServices.Factory.get();
    	    //KieContainer kContainer = ks.getKieClasspathContainer();
        	//KieSession kSession = kContainer.newKieSession("jass-rules");


    /*        // load up the knowledge base
            KieServices ks = KieServices.Factory.get();
            KieContainer kContainer = ks.getKieClasspathContainer();
            KieSession kSession = kContainer.newKieSession("jass-rules");


            System.out.println("Colour of trump is: " + trumpCardColour.name());

            kSession.insert(trumpCardColour);
            kSession.fireAllRules();

            return trumpCardColour;
*/


            // From the kie services, a container is created from the classpath
            KieServices ks = KieServices.get();
            KieContainer kc = ks.getKieClasspathContainer();

            execute( ks, kc );

            // start the program!
            String playerName1 = PlayerUtils.readPlayerNameFromCLI();
            String playerName2 = "Yoda";
            String playerName3 = "Hagrid";
            String playerName4 = "Legolas";

            Player player1 = new Player(playerName1,1);
            Player player2 = new Player(playerName2,2);
            Player player3 = new Player(playerName3,3);
            Player player4 = new Player(playerName4,4);

            // Print one Deck for Player1
            //  RuleEngine --> If Player 1 is playing, show him his cards - all other cards aren't shown
            player1.showPlayerCards();


            CardColours trumpColour = CardUtils.readTrumpColourFromCLI();

            JassGame jassGame = new JassGame(player1,player2,player3,player4,trumpColour);

            ///////////////////////////////////////////////////////////////
            // Start Game and play 9 rounds
            ///////////////////////////////////////////////////////////////

            do {
                if (jassGame.getCurrentPlayerNumber() == 1){
                    int chosenCardNumber = CardUtils.readCardToPlay(player1);
                    jassGame.playCard(chosenCardNumber);
                }
                else {
                    // Start Game for player 2 3 4
                    // Trigger rule engine
                    // look for current player

                }

            } while(jassGame.notFinished());


/*
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
                }*/


            /*    // Player1
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
*/
                // Assign points to cards

                // assign points

            //}


            //int points = Jass.startGame(trumpColour);

            //System.out.println("You achieved " + points + " points! Congratulations!");

       /*     Message message = new Message();
            message.setMessage("Hello World");
            message.setStatus(Message.HELLO);*/
            //kSession.insert(message);
            //kSession.fireAllRules();
        } catch (Exception t) {
            t.printStackTrace();
        }
    }

    public static void execute( KieServices ks, KieContainer kc ) {
        // From the container, a session is created based on
        // its definition and configuration in the META-INF/kmodule.xml file
        KieSession ksession = kc.newKieSession("jass-rules");

        // Once the session is created, the application can interact with it
        // In this case it is setting a global as defined in the
        // org/drools/examples/helloworld/HelloWorld.drl file
        ksession.setGlobal( "list", new ArrayList<Object>() );

        // The application can also setup listeners
        ksession.addEventListener( new DebugAgendaEventListener() );
        ksession.addEventListener( new DebugRuleRuntimeEventListener() );

        // Set up a file based audit logger
        KieRuntimeLogger logger = ks.getLoggers().newFileLogger( ksession, "./helloworld" );

        // To set up a ThreadedFileLogger, so that the audit view reflects events whilst debugging,
        // uncomment the next line
        // KieRuntimeLogger logger = ks.getLoggers().newThreadedFileLogger( ksession, "./helloworld", 1000 );

        // The application can insert facts into the session
        final Message message = new Message();
        message.setMessage( "Hello World" );
        message.setStatus( Message.HELLO );
        ksession.insert( message );

        // and fire the rules
        ksession.fireAllRules();

        // Close logger
        logger.close();

        // and then dispose the session
        ksession.dispose();
    }

    public static class Message {
        public static final int HELLO   = 0;
        public static final int GOODBYE = 1;

        private String          message;

        private int             status;

        public Message() {

        }

        public String getMessage() {
            return this.message;
        }

        public void setMessage(final String message) {
            this.message = message;
        }

        public int getStatus() {
            return this.status;
        }

        public void setStatus(final int status) {
            this.status = status;
        }

        public static Message doSomething(Message message) {
            return message;
        }

        public boolean isSomething(String msg,
                                   List<Object> list) {
            list.add( this );
            return this.message.equals( msg );
        }
    }

}
