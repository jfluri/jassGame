package com.jass.game;

import org.apache.commons.lang3.ArrayUtils;

public class Player {

    private final String name;
    private Card[] playCards = new Card[8];
    private final int playerNumber;
    private int points;

    public Player(String name, int playerNumber){
        this.name = name;
        this.playerNumber = playerNumber;
    }

    // methods
    public String getName() {
        return name;
    }

    public int getPlayerNumber() {return playerNumber;}

    public Card[] getPlayCards() {
        return playCards;
    }

    public void addPoints (int newPoints){
        this.points += newPoints;
    }

    public void showPlayerCards(){
        System.out.println("---------------------------------------------");
        for (int i = 0; i < playCards.length; i++){
            if(playCards[i]!=null)
                System.out.println("[" + i + "] - "+  playCards[i].cardType + "  of  " + playCards[i].cardColour);
        }
        System.out.println("---------------------------------------------");

    }

    public void removePlayedCardFromDeck(int chosenCardNumber) {

        playCards = ArrayUtils.remove(playCards, chosenCardNumber);

    }

}
