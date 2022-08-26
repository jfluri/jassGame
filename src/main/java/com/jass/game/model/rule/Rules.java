package com.jass.game.model.rule;

import com.jass.game.model.rule.impl.*;

public enum Rules {
    FOUR_SAME_CARD_TYPE(100, new FourSameCardRuleImpl()),
    FOUR_JACK(200, new FourJackRuleImpl()),
    TRUMP_KIND_AND_QUEEN(20, new TrumpKingAndQueenRuleImpl()),
    THREE_SAME_COLOR_CARDS_IN_ROW(20, new ThreeSameColorCardInRowRuleImpl()),
    FOUR_SAME_COLOR_CARDS_IN_ROW(50, new FourSameColorCardInRowRuleImpl()),
    FIVE_SAME_COLOR_CARDS_IN_ROW(100, new FiveSameColorCardInRowRuleImpl()),
    ;
    private final int point;
    private final JassRuleMather jassRuleMather;

    Rules(final int point, final JassRuleMather jassRuleMather) {
        this.point = point;
        this.jassRuleMather = jassRuleMather;
    }

    public int getPoint() {
        return point;
    }

    public JassRuleMather getJassRuleMather() {
        return jassRuleMather;
    }
}
