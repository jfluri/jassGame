package com.jass.game.model.rule.impl;

import com.jass.game.model.Card;
import com.jass.game.model.CardColor;
import com.jass.game.model.Player;
import com.jass.game.model.rule.JassRuleMather;

import java.util.stream.Collectors;

public class FourSameCardRuleImpl implements JassRuleMather {

    @Override
    public boolean isMatch(final Player player, final CardColor trumpColor) {
        return player.getPlayCards()
                .stream()
                .collect(Collectors.groupingBy(Card::getCardType))
                .values()
                .stream()
                .anyMatch(list -> list.size() == 4);
    }
}
