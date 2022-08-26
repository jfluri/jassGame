package com.jass.game.model.rule.impl;

import com.jass.game.model.Card;
import com.jass.game.model.CardColor;
import com.jass.game.model.CardType;
import com.jass.game.model.Player;
import com.jass.game.model.rule.JassRuleMather;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FourSameColorCardInRowRuleImpl implements JassRuleMather {

    @Override
    public boolean isMatch(final Player player, final CardColor trumpColor) {
        return player.getPlayCards()
                .stream()
                .collect(Collectors.groupingBy(Card::getCardColor))
                .values()
                .stream()
                .anyMatch(this::isFourConsecutive);
    }

    private boolean isFourConsecutive(final List<Card> cards) {
        final Set<CardType> cardTypes = cards.stream()
                .map(Card::getCardType)
                .collect(Collectors.toSet());

        final CardType[] allCardTypes = CardType.values();
        for (int i = 0; i < allCardTypes.length - 3; i++) {
            if (hasConsecutiveFromIndex(allCardTypes, i, cardTypes, 4)) {
                return true;
            }
        }

        return false;
    }

    private boolean hasConsecutiveFromIndex(final CardType[] allCardTypes, final int index, final Set<CardType> cardTypes, final int numConsecutive) {
        for (int i = index; i < index + numConsecutive; i++) {
            final CardType cardType = allCardTypes[i];
            if (!cardTypes.contains(cardType)) {
                return false;
            }
        }
        return true;
    }
}
