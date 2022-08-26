package com.jass.game.model.rule.impl;

import com.jass.game.model.CardColor;
import com.jass.game.model.CardType;
import com.jass.game.model.Player;
import com.jass.game.model.rule.JassRuleMather;

public class FourJackRuleImpl implements JassRuleMather {

    @Override
    public boolean isMatch(final Player player, final CardColor trumpColor) {
        final long numJacks = player.getPlayCards()
                .stream()
                .filter(card -> CardType.JACK.equals(card.getCardType()))
                .count();
        return 4 == numJacks;
    }
}
