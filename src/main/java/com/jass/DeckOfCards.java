package com.jass;

import java.util.Random;
import java.util.Scanner;

public class DeckOfCards {

    public static final int numberOfCards = 36;

    public static Card[] deckOfCards = new Card[numberOfCards];

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


    public void ShuffleCards(){
        Random rand = new Random();
        int j;
        for(int i=0; i<numberOfCards; i++){
            j = rand.nextInt(numberOfCards);
            Card temp = deckOfCards[i];
            deckOfCards[i]=deckOfCards[j];
            deckOfCards[j]= temp;
        }
    }

    public static void showCards(){
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


    public void dealCards(Player player1,Player player2,Player player3,Player player4){

        int count = 0;

        for (Card card : deckOfCards){

            if (count>26){
                player1.playCards[count%9] = card;
            }
            else if (count>17){
                player2.playCards[count%9] = card;
            }
            else if (count>8){
                player3.playCards[count%9] = card;
            }
            else{
                player4.playCards[count%9] = card;
            }
            count++;
        }
    }

    public static int enterCardToPlay(Player player1){

        System.out.println("Enter the Number of the card to play :");

        Scanner sc = new Scanner(System.in);
        int chosenCardPosition = sc.nextInt();

        if (chosenCardPosition >= 0 && chosenCardPosition < 9){
            return chosenCardPosition;
        }
        else {
            return 99;
        }
    }

}
