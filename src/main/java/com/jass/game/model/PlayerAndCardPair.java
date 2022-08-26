package com.jass.game.model;

public class PlayerAndCardPair {

    private final Player player;
    private final Card card;

    public PlayerAndCardPair(final Player player, final Card card) {
        this.player = player;
        this.card = card;
    }

    public Player getPlayer() {
        return player;
    }

    public Card getCard() {
        return card;
    }
}
