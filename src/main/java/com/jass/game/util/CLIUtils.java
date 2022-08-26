package com.jass.game.util;

import com.jass.game.model.CardColor;
import com.jass.game.model.Player;

import java.util.List;
import java.util.Scanner;

public class CLIUtils {

    final Scanner sc = new Scanner(System.in);  //System.in is a standard input stream

    public String readPlayerNameFromCLI() {
        System.out.print("Enter Player Name: ");
        return sc.next();
    }

    public CardColor readTrumpColourFromCLI() {
        final List<String> cardColors = CardColor.getCardColors();
        System.out.println(cardColors.toString());
        System.out.println("Enter trump color name or index from above: ");

        String enteredValue = sc.next();

        while (true) {
            if (NumberUtils.isNumber(enteredValue)) {
                final int enteredNumber = Integer.parseInt(enteredValue);
                if (enteredNumber <= 0 || enteredNumber > cardColors.size()) {
                    System.out.printf("Please enter number between [%d, %d] or the name of the color: %n", 1, cardColors.size());
                } else {
                    return CardColor.values()[enteredNumber - 1];
                }
            } else {
                final CardColor cardColor = CardColor.getByCardColor(enteredValue);
                if (cardColor == null) {
                    System.out.printf("Please enter number between [%d, %d] or the name of the color: %n", 1, cardColors.size());
                } else {
                    return cardColor;
                }
            }
            enteredValue = sc.next();
        }
    }

    public int readCardToPlay(final Player player) {
        player.showPlayerCards();
        System.out.println("Please choose the card to play: ");

        String enteredValue = sc.next();
        final int numCardsPlayerHas = player.getPlayCards().size();

        while (true) {
            if (NumberUtils.isNumber(enteredValue)) {
                final int enteredNumber = Integer.parseInt(enteredValue);
                if (enteredNumber < 0 || enteredNumber >= numCardsPlayerHas) {
                    System.out.printf("Please enter number between [%d, %d]: %n", 0, numCardsPlayerHas - 1);
                } else {
                    return enteredNumber;
                }
            } else {
                System.out.printf("Please enter number between [%d, %d]: %n", 0, numCardsPlayerHas - 1);
            }
            enteredValue = sc.next();
        }
    }

    public static void printLine() {
        System.out.println("---------------------------------------------");
    }
}
