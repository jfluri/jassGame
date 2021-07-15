package com.jass;

import java.util.Random;
import java.util.Scanner;

import static com.jass.DeckOfCards.enterCardToPlay;

public class Player {

    static String name;
    Card[] playCards = new Card[9];

    public Player(String name){
        this.name = name;
    }

    // methods
    public static String getName() {
        return name;
    }

    public static int readInCardToPlay(Player player1) {
        int chosenCardNumber;

        chosenCardNumber = enterCardToPlay(player1);

        return chosenCardNumber;
    }

    public static int playCard(Player player, String trumpColour) {

        // load up the knowledge base
        //KieServices ks = KieServices.Factory.get();
        //KieContainer kContainer = ks.getKieClasspathContainer();
        //KieSession kSession = kContainer.newKieSession("rules");

        Random rand = new Random();

        int upperbound = player.playCards.length + 1 ;

        int cardNumber = rand.nextInt(upperbound);

        //kSession.insert(trumpColour);
        //kSession.insert(player.playCards);
        //kSession.fireAllRules();


        return cardNumber+1;
    }


    public void showPlayerCards(){
        System.out.println("---------------------------------------------");
        for (int i = 0; i < playCards.length; i++){
            if(playCards[i]!=null)
                System.out.println("[" + i + "] - "+  playCards[i].cardType + "  of  " + playCards[i].cardColour);
        }
        System.out.println("---------------------------------------------");

    }


        public static String enterPlayerCredentials(){
            System.out.println("Enter your name :");

            try{
            Scanner sc = new Scanner(System.in);
            String playerName = sc.nextLine();
            System.out.println("Your chosen Name is: " + playerName);
                return playerName;
            }
            catch(Exception e){

                System.out.println("Your name cannot be empty - default name will be set!");
                System.out.println("Your name is CleverLlama");
                return "CleverLlama";

            }

        };


}
