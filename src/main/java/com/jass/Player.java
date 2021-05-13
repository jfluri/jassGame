package com.jass;

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
        do {
            chosenCardNumber = enterCardToPlay(player1);
        } while (chosenCardNumber != 99);
        return chosenCardNumber;
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
