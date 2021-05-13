package com.jass;


public class Card {


    public String cardColour;
    public String cardType;

    public Card(String cardColour, String cardType){
        this.cardColour = cardColour;
        this.cardType = cardType;
    }


    public static int setCardValuesNonTrumpColour(String trumpColour, Card card[], int pos){

           System.out.println(card[pos].cardColour + card[pos].cardType);

           int cardValue = 0;

           if(card[pos].cardColour.toUpperCase() != trumpColour.toUpperCase()){
               switch(card[pos].cardType){
                   case "ACE" :
                       cardValue = 11;
                       break;
                   case "KING" :
                       cardValue = 4;
                       break;
                   case "QUEEN" :
                       cardValue = 3;
                       break;
                   case "JACK" :
                       cardValue = 2;
                       break;
                   case "TEN" :
                       cardValue = 10;
                       break;
                   case "NINE" :
                       cardValue = 0;
                       break;
                   case "EIGHT" :
                       cardValue = 0;
                       break;
                   case "SEVEN" :
                       cardValue = 0;
                       break;
                   case "SIX" :
                       cardValue = 0;
                       break;
               }

           }

           return cardValue;

    }

    public static int setCardValuesTrumpColour(String trumpColour, Card card[], int pos){

        System.out.println(card[pos].cardColour + card[pos].cardType);

        int cardValue = 0;

        if(card[pos].cardColour.toUpperCase() == trumpColour.toUpperCase()){
            switch(card[pos].cardType){
                case "ACE":
                    cardValue = 11;
                    break;
                case "KING" :
                    cardValue = 4;
                    break;
                case "QUEEN" :
                    cardValue = 3;
                    break;
                case "JACK" :
                    cardValue = 20;
                    break;
                case "TEN" :
                    cardValue = 10;
                    break;
                case "NINE" :
                    cardValue = 14;
                    break;
                case "EIGHT" :
                    cardValue = 0;
                    break;
                case "SEVEN" :
                    cardValue = 0;
                    break;
                case "SIX" :
                    cardValue = 0;
                    break;
            }

        }

        return cardValue;

    }


}
