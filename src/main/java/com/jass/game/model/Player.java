package com.jass.game.model;

import com.jass.game.util.CLIUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Player {

    private final String name;
    private final int playerNumber;
    private final List<Card> playCards;
    private final boolean isComputer;
    private final CLIUtils cliUtils;
    private int points;

    public Player(final String name, final int playerNumber, final boolean isComputer, final CLIUtils cliUtils) {
        this.name = name;
        this.playerNumber = playerNumber;
        this.isComputer = isComputer;
        this.cliUtils = cliUtils;
        this.playCards = new ArrayList<>();
        this.points = 0;
    }

    // methods
    public String getName() {
        return name;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public List<Card> getPlayCards() {
        return playCards;
    }

    public void addCard(final Card card) {
        playCards.add(card);
    }

    public void addPoints(final int newPoints) {
        this.points += newPoints;
    }

    public int getPoints() {
        return points;
    }

    public boolean hasCardById(final String cardId) {
        return playCards
                .stream()
                .map(Card::getCardId)
                .anyMatch(cardId2 -> cardId2.equals(cardId));
    }

    public boolean hasTrumpCardById(final String cardId) {
        return playCards
                .stream()
                .filter(Card::isTrumpColor)
                .map(Card::getCardId)
                .anyMatch(cardId2 -> cardId2.equals(cardId));
    }

    public void showPlayerCards() {
        System.out.println("----------------My Cards----------------");
        for (int i = 0; i < playCards.size(); i++) {
            final Card card = playCards.get(i);
            System.out.println("[" + i + "] - " + card);
        }
        CLIUtils.printLine();
        System.out.println();
    }

    public Card removePlayedCardFromDeck(final int chosenCardIndex) {
        return playCards.remove(chosenCardIndex);
    }

    public int chooseCardToPlay(final List<PlayerAndCardPair> roundPlayedCards) {
        if (isComputer) {
            final Optional<Card> maxTrumpCard = playCards.stream()
                    .filter(Card::isTrumpColor)
                    .max(Comparator.comparing(Card::getPoint));
            if (maxTrumpCard.isPresent()) {
                return getIndexOfTheCard(maxTrumpCard.get());
            }

            if (roundPlayedCards != null) {
                final Optional<Card> nonTrumpCard = playCards.stream()
                        .filter(card -> card.getCardType().equals(roundPlayedCards.get(0).getCard().getCardType()))
                        .max(Comparator.comparing(Card::getPoint));

                if (nonTrumpCard.isPresent()) {
                    return getIndexOfTheCard(nonTrumpCard.get());
                }
            }

            final Optional<Card> maxValueCard = playCards.stream()
                    .max(Comparator.comparing(Card::getPoint));

            return getIndexOfTheCard(maxValueCard.get());
        } else {
            return cliUtils.readCardToPlay(this);
        }
    }

    private int getIndexOfTheCard(final Card card) {
        for (int i = 0; i < playCards.size(); i++) {
            if (card.equals(playCards.get(i))) {
                return i;
            }
        }
        throw new IllegalStateException();
    }
}
