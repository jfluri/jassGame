package com.jass.game.model.rule.impl;

import com.jass.game.model.CardColor;
import com.jass.game.model.CardType;
import com.jass.game.model.Player;
import com.jass.game.model.rule.JassRuleMather;

import java.util.Arrays;

public class TrumpKingAndQueenRuleImpl implements JassRuleMather {

    @Override
    public boolean isMatch(final Player player, final CardColor trumpColor) {
        return 2 == player.getPlayCards()
                .stream()
                .filter(card -> trumpColor.equals(card.getCardColor()))
                .filter(card -> Arrays.asList(CardType.KING, CardType.QUEEN).contains(card.getCardType()))
                .count();
    }
}
