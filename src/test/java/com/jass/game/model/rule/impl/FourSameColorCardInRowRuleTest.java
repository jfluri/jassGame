package com.jass.game.model.rule.impl;

import com.jass.game.model.Card;
import com.jass.game.model.CardColor;
import com.jass.game.model.CardType;
import com.jass.game.model.Player;
import com.jass.game.util.CLIUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FourSameColorCardInRowRuleTest {


    private static Card buildCard(final CardColor cardColor, final CardType cardType) {
        return new Card(cardColor, cardType, CardColor.SPADE);
    }

    @Test
    @DisplayName("Test same color 4 consecutive cards rule is applied")
    public void sameColorFourConsecutiveCardsIsApplied() {
        final Player player = new Player("Toko", 1, false, new CLIUtils()) {{
            addCard(buildCard(CardColor.CHECK, CardType.JACK));
            addCard(buildCard(CardColor.SPADE, CardType.JACK));
            addCard(buildCard(CardColor.HEART, CardType.JACK));
            addCard(buildCard(CardColor.CROSS, CardType.JACK));
            addCard(buildCard(CardColor.CHECK, CardType.ACE));
            addCard(buildCard(CardColor.CHECK, CardType.NINE));
            addCard(buildCard(CardColor.CHECK, CardType.EIGHT));
            addCard(buildCard(CardColor.CHECK, CardType.SEVEN));
            addCard(buildCard(CardColor.CHECK, CardType.SIX));
        }};

        assertTrue(new FourSameColorCardInRowRuleImpl().isMatch(player, CardColor.HEART));
    }

    @Test
    @DisplayName("Test same color 4 consecutive cards is not applied")
    public void sameColorFourConsecutiveCardsIsNotApplied() {
        final Player player = new Player("Toko", 1, false, new CLIUtils()) {{
            addCard(buildCard(CardColor.CHECK, CardType.JACK));
            addCard(buildCard(CardColor.SPADE, CardType.JACK));
            addCard(buildCard(CardColor.HEART, CardType.JACK));
            addCard(buildCard(CardColor.CROSS, CardType.SIX));
            addCard(buildCard(CardColor.CHECK, CardType.ACE));
            addCard(buildCard(CardColor.CHECK, CardType.KING));
            addCard(buildCard(CardColor.CHECK, CardType.NINE));
            addCard(buildCard(CardColor.HEART, CardType.KING));
            addCard(buildCard(CardColor.HEART, CardType.QUEEN));
        }};

        assertFalse(new FourSameCardRuleImpl().isMatch(player, CardColor.CHECK));
    }

}
