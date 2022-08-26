package com.jass.game.util;

public class NumberUtils {

    public static boolean isNumber(final String enteredValue) {
        try {
            Integer.parseInt(enteredValue);
            return true;
        } catch (Exception ignore) {
            return false;
        }
    }
}
