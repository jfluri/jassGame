package com.jass;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JassTest {

    @Test
    @DisplayName("Save and return Trump Colour Check")
    public void saveAndReturnTrumpColourCheck() {

        String input = "CHECK";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String trumpColour = Jass.setTrumpColour();

        assertEquals(input, trumpColour);
    }

    @Test
    @DisplayName("Save and return Trump Colour Heart")
    public void saveAndReturnTrumpColourHeart() {

        String input = "HEART";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String trumpColour = Jass.setTrumpColour();

        assertEquals(input, trumpColour);
    }

    @Test
    @DisplayName("Enter invalid Trump Colour")
    public void enterInvalidTrumpColour() {

        String input = "BLABLA";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String trumpColour = Jass.setTrumpColour();

        assertEquals("HEART", trumpColour);
    }

}

