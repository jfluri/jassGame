package com.jass.rules.playerinitialpointsrules;

import com.jass.game.model.Card;
import com.jass.game.model.CardColor;
import com.jass.game.model.CardType;
import com.jass.game.model.Player;
import com.jass.game.util.CLIUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerInitialPointsRulesTest {

    private static KieSession kieSession;

    @BeforeAll
    public static void beforeAll() {
        final KieServices ks = KieServices.Factory.get();
        final KieContainer kContainer = ks.getKieClasspathContainer();
        kieSession = kContainer.newKieSession("player-initial-points-rulesKS");
    }

    @Test
    @DisplayName("Test Four Jack")
    public void testFourJack() {
        final Player player = new Player("tornike", 1, false, new CLIUtils());
        player.addCard(new Card(CardColor.HEART, CardType.JACK, CardColor.CHECK));
        player.addCard(new Card(CardColor.CROSS, CardType.JACK, CardColor.CHECK));
        player.addCard(new Card(CardColor.SPADE, CardType.JACK, CardColor.CHECK));
        player.addCard(new Card(CardColor.CHECK, CardType.JACK, CardColor.CHECK));


        kieSession.insert(player);
        kieSession.fireAllRules();

        assertEquals(200, player.getPoints());
    }

    @Test
    @DisplayName("Test Trump Queen And King")
    public void testTrumpQueenAndKing() {
        final Player player1 = new Player("tornike", 1, false, new CLIUtils()) {{
            addCard(new Card(CardColor.CHECK, CardType.KING, CardColor.CHECK));
            addCard(new Card(CardColor.CHECK, CardType.QUEEN, CardColor.CHECK));
        }};

        final Player player2 = new Player("tornike", 1, false, new CLIUtils()) {{
            addCard(new Card(CardColor.SPADE, CardType.KING, CardColor.SPADE));
            addCard(new Card(CardColor.SPADE, CardType.QUEEN, CardColor.SPADE));
        }};

        final Player player3 = new Player("tornike", 1, false, new CLIUtils()) {{
            addCard(new Card(CardColor.CROSS, CardType.KING, CardColor.CROSS));
            addCard(new Card(CardColor.CROSS, CardType.QUEEN, CardColor.CROSS));
        }};

        final Player player4 = new Player("tornike", 1, false, new CLIUtils()) {{
            addCard(new Card(CardColor.HEART, CardType.KING, CardColor.HEART));
            addCard(new Card(CardColor.HEART, CardType.QUEEN, CardColor.HEART));
        }};


        kieSession.insert(player1);
        kieSession.insert(player2);
        kieSession.insert(player3);
        kieSession.insert(player4);
        kieSession.fireAllRules();

        assertEquals(20, player1.getPoints());
        assertEquals(20, player2.getPoints());
        assertEquals(20, player3.getPoints());
        assertEquals(20, player4.getPoints());
    }

    @Test
    @DisplayName("Test four same card")
    public void testFourSameCard() {
        final Player player = new Player("tornike", 1, false, new CLIUtils()) {{
            addCard(Card.of(CardColor.CHECK, CardType.ACE));
            addCard(Card.of(CardColor.CROSS, CardType.ACE));
            addCard(Card.of(CardColor.HEART, CardType.ACE));
            addCard(Card.of(CardColor.SPADE, CardType.ACE));
            addCard(Card.of(CardColor.CHECK, CardType.KING));
            addCard(Card.of(CardColor.CROSS, CardType.KING));
            addCard(Card.of(CardColor.HEART, CardType.KING));
            addCard(Card.of(CardColor.SPADE, CardType.KING));
        }};

        kieSession.insert(player);
        kieSession.fireAllRules();

        assertEquals(100, player.getPoints());
    }

    @Test
    @DisplayName("Test same color 3 consecutive cards rule is applied")
    public void sameColorThreeConsecutiveCardsIsApplied() {
        final Player player = new Player("Toko", 1, false, new CLIUtils()) {{
            addCard(Card.of(CardColor.CHECK, CardType.EIGHT));
            addCard(Card.of(CardColor.CHECK, CardType.SEVEN));
            addCard(Card.of(CardColor.CHECK, CardType.SIX));
        }};

        kieSession.insert(player);
        kieSession.fireAllRules();

        assertEquals(20, player.getPoints());
    }

    @Test
    @DisplayName("Test same color 5 consecutive cards rule is applied")
    public void sameColorFiveConsecutiveCardsIsApplied() {
        final Player player = new Player("Toko", 1, false, new CLIUtils()) {{
            addCard(Card.of(CardColor.CHECK, CardType.TEN));
            addCard(Card.of(CardColor.CHECK, CardType.NINE));
            addCard(Card.of(CardColor.CHECK, CardType.EIGHT));
            addCard(Card.of(CardColor.CHECK, CardType.SEVEN));
            addCard(Card.of(CardColor.CHECK, CardType.SIX));
        }};

        kieSession.insert(player);
        kieSession.fireAllRules();

        assertEquals(100, player.getPoints());
    }
}
