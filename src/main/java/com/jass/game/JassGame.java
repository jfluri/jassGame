package com.jass.game;

import com.jass.game.model.Card;
import com.jass.game.model.CardColor;
import com.jass.game.model.Player;
import com.jass.game.model.PlayerAndCardPair;
import com.jass.game.util.CLIUtils;
import org.kie.api.runtime.KieSession;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class JassGame {

    private final DeckOfCards deck;
    private final Player player1;
    private final Player player2;
    private final Player player3;
    private final Player player4;
    private final int numRounds;
    private Player[] players;
    private int currentPlayerIndex;
    private List<PlayerAndCardPair> roundPlayedCards;
    private int currentRound;

    public JassGame(final Player player1, final Player player2, final Player player3, final Player player4, final CardColor trumpColour, final KieSession cardPointRules, final KieSession initialPointRules) {
        this.player1 = player1;
        this.player2 = player2;
        this.player3 = player3;
        this.player4 = player4;
        players = new Player[]{player1, player2, player3, player4};
        currentPlayerIndex = 0;

        currentRound = 1; // Game is over when rounds are 0
        numRounds = 9; // Game is over when rounds are 0

        while (getCurrentPlayerNumber() != 1) {
            playerHasPlayedCard();
        }

        deck = new DeckOfCards(trumpColour);
        deck.shuffleCards();
        for (final Card card : deck.getDeckOfCards()) {
            cardPointRules.insert(card);
        }
        cardPointRules.fireAllRules();

        dealCards();

        applyStartingPoints(initialPointRules);
    }

    private void applyStartingPoints(final KieSession initialPointRules) {
        System.out.println("--------Applying Starting bonus points--------");
        for (final Player player : players) {
            initialPointRules.insert(player);
        }
        initialPointRules.fireAllRules();
        for (final Player player : players) {
            System.out.println(player.getName() + String.format(" got %d points", player.getPoints()));
        }
        CLIUtils.printLine();
        System.out.println();
    }

    private void showResultsSoFar() {
        System.out.println("--------Players Result After Round--------");
        for (final Player player : players) {
            System.out.println(player.getName() + String.format(": %d points", player.getPoints()));
        }
        CLIUtils.printLine();
        System.out.println();
    }

    public void dealCards() {
        for (int i = 0; i < deck.getDeckOfCards().length; i++) {
            final Player player = players[i % 4];
            final Card card = deck.getDeckOfCards()[i];
            player.addCard(card);
        }
    }

    public boolean isFinished() {
        return currentRound > numRounds;
    }

    public boolean isNotFinished() {
        return !isFinished();
    }

    public int getCurrentPlayerNumber() {
        return getCurrentPlayer().getPlayerNumber();
    }

    public Player getCurrentPlayer() {
        return players[currentPlayerIndex];
    }

    public void finishRound() {
        currentRound++;
        roundPlayedCards = null;
        currentPlayerIndex = 0;
        players = new Player[]{player1, player2, player3, player4};
    }

    private void playerHasPlayedCard() {
        currentPlayerIndex++;
    }

    public void playRound() {
        CLIUtils.printLine();
        System.out.println("Starting round " + currentRound);
        System.out.println();
        for (int i = 0; i < 4; i++) {
            final Player playerToPlay = getCurrentPlayer();
            final int cardNumber = playerToPlay.chooseCardToPlay(roundPlayedCards);
            final Card card = playCard(cardNumber);
            System.out.println(playerToPlay.getName() + " turn. Chosen card is " + card);

            addPairToCurrentRoundList(new PlayerAndCardPair(playerToPlay, card));
        }
        System.out.println();

        final Player winner = calculateRoundWinner();
        final int point = calculateRoundWinnerPoints();
        winner.addPoints(point);

        System.out.printf("Finished round %d. The winner is %s with point %d\n", currentRound, winner.getName(), point);
        CLIUtils.printLine();
        System.out.println();

        finishRound();
    }

    private Player calculateRoundWinner() {
        return roundPlayedCards
                .stream()
                .max(Comparator.comparing(pair -> pair.getCard().getPoint()))
                .get()
                .getPlayer();
    }

    private int calculateRoundWinnerPoints() {
        return roundPlayedCards
                .stream()
                .map(PlayerAndCardPair::getCard)
                .map(Card::getPoint)
                .reduce(0, Integer::sum);
    }

    private void addPairToCurrentRoundList(final PlayerAndCardPair playerAndCardPair) {
        if (roundPlayedCards == null) {
            roundPlayedCards = new ArrayList<>();
        }
        roundPlayedCards.add(playerAndCardPair);
    }

    private Card playCard(final int chosenCardNumber) {
        final Player currentPlayer = getCurrentPlayer();
        final Card card = currentPlayer.removePlayedCardFromDeck(chosenCardNumber);
        playerHasPlayedCard();
        return card;
    }

    public void startGame() {
        while (isNotFinished()) {
            playRound();
            showResultsSoFar();
        }

        CLIUtils.printLine();
        final Player gameWinner = getGameWinner();
        System.out.printf("The game winner is %s with points %d%n", gameWinner.getName(), gameWinner.getPoints());
        CLIUtils.printLine();
        System.out.println();
    }

    private Player getGameWinner() {
        return Arrays.stream(players)
                .max(Comparator.comparing(Player::getPoints))
                .get();
    }
}
