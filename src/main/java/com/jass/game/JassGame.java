package com.jass.game;

public class JassGame {

    private final DeckOfCards deck;

    private final Player player1;
    private final Player player2;
    private final Player player3;
    private final Player player4;
    private final CardColours trumpColour;
    private int rounds;
    private Player currentPlayer;


    public JassGame(Player player1, Player player2, Player player3, Player player4, CardColours trumpColour) {

        this.player1 = player1;
        this.player2 = player2;
        this.player3 = player3;
        this.player4 = player4;
        this.trumpColour = trumpColour;
        rounds = 9; // Spiel ist fertig wenn Rounds 0 sind
        currentPlayer = player1;

        deck = new DeckOfCards();
        // System.out.println("UnShuffeled Cards.");
        //deck.showCards();
        deck.shuffleCards();
        //System.out.println("Shuffeled Cards.");
        //deck.showCards();

        dealCards(player1,player2,player3,player4);
    }


    public void dealCards(Player player1,Player player2,Player player3,Player player4){

        int count = 0;

        for (Card card : deck.getDeckOfCards()){

            if (count>26){
                player1.getPlayCards()[count%9] = card;
            }
            else if (count>17){
                player2.getPlayCards()[count%9] = card;
            }
            else if (count>8){
                player3.getPlayCards()[count%9] = card;
            }
            else{
                player4.getPlayCards()[count%9] = card;
            }
            count++;
        }
    }


    public boolean notFinished() {
        return rounds != 0;
    }

    public int getCurrentPlayerNumber() {
        return currentPlayer.getPlayerNumber();
    }

    public void startNextRound() {
        rounds = rounds --;
    }

    public void playCard(int chosenCardNumber) {

        currentPlayer.removePlayedCardFromDeck(chosenCardNumber);

        playerHasPlayedCard();
    }

    private void playerHasPlayedCard() {

    }
}
