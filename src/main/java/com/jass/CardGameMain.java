package com.jass;

import com.jass.game.JassGame;
import com.jass.game.model.CardColor;
import com.jass.game.model.Player;
import com.jass.game.util.CLIUtils;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.Arrays;

/**
 * This is a com class to launch a rule.
 */
public class CardGameMain {

    public static void main(String[] args) {

        final KieSession cardPointRules = getKieSession("card-point-rulesKS");
        final KieSession initialPointRules = getKieSession("player-initial-points-rulesKS");

        final CLIUtils cliUtils = new CLIUtils();

        // start the program!
        final String playerName1 = cliUtils.readPlayerNameFromCLI();
        final String playerName2 = "Yoda";
        final String playerName3 = "Hagrid";
        final String playerName4 = "Legolas";

        System.out.println("Players: " + Arrays.asList(playerName1, playerName2, playerName3, playerName4));
        CLIUtils.printLine();
        System.out.println();

        final Player player1 = new Player(playerName1, 1, false, cliUtils);
        final Player player2 = new Player(playerName2, 2, true, cliUtils);
        final Player player3 = new Player(playerName3, 3, true, cliUtils);
        final Player player4 = new Player(playerName4, 4, true, cliUtils);

        final CardColor trumpColour = cliUtils.readTrumpColourFromCLI();

        CLIUtils.printLine();
        System.out.println("Trump Color: " + trumpColour.toString());
        CLIUtils.printLine();
        System.out.println();

        final JassGame jassGame = new JassGame(player1, player2, player3, player4, trumpColour, cardPointRules, initialPointRules);

        player1.showPlayerCards();

        ///////////////////////////////////////////////////////////////
        // Start Game and play 9 rounds
        ///////////////////////////////////////////////////////////////

        jassGame.startGame();
    }

    private static KieSession getKieSession(final String sessionName) {
        final KieServices ks = KieServices.Factory.get();
        final KieContainer kContainer = ks.getKieClasspathContainer();
        return kContainer.newKieSession(sessionName);
    }
}
