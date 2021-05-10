package com.jass;



public class Card {


    public String cardColour;
    public String cardType;
    public int cardValue = 0;

    public Card(String cardColour, String cardType){
        this.cardColour = cardColour;
        this.cardType = cardType;
    }


    public static int setCardValuesNonTrumpColour(String trumpColour, Card card[], int pos){

           System.out.println(card[pos].cardColour + card[pos].cardType);
           return 10;

    }

    //public static void setCardValuesTrumpColour(String trumpColour, DeckOfCards deck){

    //}


}
