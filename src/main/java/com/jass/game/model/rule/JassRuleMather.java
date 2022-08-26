package com.jass.game.model.rule;

import com.jass.game.model.CardColor;
import com.jass.game.model.Player;

public interface JassRuleMather {

    boolean isMatch(final Player player, final CardColor trumpColor);
}
