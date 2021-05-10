package com.jass;

import java.util.Scanner;

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


    public void showPlayerCards(){
        System.out.println("---------------------------------------------");
        for (Card card : playCards){
            if(card!=null)
                System.out.println(card.cardType + "  of  " + card.cardColour);
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
