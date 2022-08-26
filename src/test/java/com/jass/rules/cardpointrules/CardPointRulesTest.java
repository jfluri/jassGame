package com.jass.rules.cardpointrules;

import com.jass.game.model.Card;
import com.jass.game.model.CardColor;
import com.jass.game.model.CardType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardPointRulesTest {

    @Test
    @DisplayName("Test trump Queen points")
    public void testTrumpQueenPoints() {
        final KieServices ks = KieServices.Factory.get();
        final KieContainer kContainer = ks.getKieClasspathContainer();
        final KieSession kieSession = kContainer.newKieSession("card-point-rulesKS");

        final Card card = new Card(CardColor.CHECK, CardType.QUEEN, CardColor.CHECK);

        kieSession.insert(card);
        kieSession.fireAllRules();

        assertEquals(3, card.getPoint());
    }

    @Test
    @DisplayName("Test trump Jack points")
    public void testTrumpJackPoints() {
        final KieServices ks = KieServices.Factory.get();
        final KieContainer kContainer = ks.getKieClasspathContainer();
        final KieSession kieSession = kContainer.newKieSession("card-point-rulesKS");

        final Card card = new Card(CardColor.CHECK, CardType.JACK, CardColor.CHECK);

        kieSession.insert(card);
        kieSession.fireAllRules();

        assertEquals(20, card.getPoint());
    }

    @Test
    @DisplayName("Test Eight Card points")
    public void testEightPoints() {
        final KieServices ks = KieServices.Factory.get();
        final KieContainer kContainer = ks.getKieClasspathContainer();
        final KieSession kieSession = kContainer.newKieSession("card-point-rulesKS");

        final Card card = new Card(CardColor.CHECK, CardType.EIGHT, CardColor.SPADE);

        kieSession.insert(card);
        kieSession.fireAllRules();

        assertEquals(0, card.getPoint());
    }
}
