package com.jass.game;

import java.util.Random;

public class DeckOfCards {

    public  final int numberOfCards = 36;

    private  Card[] deckOfCards = new Card[numberOfCards];

    public DeckOfCards(){

        int count=0;

        String[] cardColour = { CardColours.CHECK.getCardColour(),
                                CardColours.CROSS.getCardColour(),
                                CardColours.HEART.getCardColour(),
                                CardColours.SPADE.getCardColour()
        };

        String[] cardType ={    CardTypes.ACE.getCardType(),
                                CardTypes.KING.getCardType(),
                                CardTypes.QUEEN.getCardType(),
                                CardTypes.JACK.getCardType(),
                                CardTypes.TEN.getCardType(),
                                CardTypes.NINE.getCardType(),
                                CardTypes.EIGHT.getCardType(),
                                CardTypes.SEVEN.getCardType(),
                                CardTypes.SIX.getCardType()
        };


        for (String s:cardColour){
            for (String r:cardType){

                Card card = new Card(s, r);
                this.deckOfCards[count] = card;
                count++;
            }
        }


    }
    public Card[] getDeckOfCards(){
        return this.deckOfCards;
    }


    public void shuffleCards(){
        Random rand = new Random();
        int j;
        for(int i=0; i<numberOfCards; i++){
            j = rand.nextInt(numberOfCards);
            Card temp = deckOfCards[i];
            deckOfCards[i]=deckOfCards[j];
            deckOfCards[j]= temp;
        }
    }

    public  void showCards(){
        System.out.println("---------------------------------------------");
        int count =0;
        for (Card card : deckOfCards){
            System.out.print(card.cardType + " of " + card.cardColour + "     ");
            count++;
            if(count%3==0)
                System.out.println("");
        }
        System.out.println("---------------------------------------------");
    }







}
