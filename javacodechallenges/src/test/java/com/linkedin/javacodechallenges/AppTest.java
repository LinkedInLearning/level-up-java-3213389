package com.linkedin.javacodechallenges;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AppTest {

    @Test
    public void scrabbleWordCalculator() {
        assertEquals(10, App.wordScoreCalculator("very"));
        assertEquals(12, App.wordScoreCalculator("zoo"));
        assertEquals(28, App.wordScoreCalculator("maximize"));
        assertEquals(17, App.wordScoreCalculator("exercise"));
        assertEquals(27, App.wordScoreCalculator("jukebox"));
        assertEquals(26, App.wordScoreCalculator("flapjack"));
        assertEquals(25, App.wordScoreCalculator("squeeze"));
        assertEquals(11, App.wordScoreCalculator("school"));
        assertEquals(9, App.wordScoreCalculator("ex"));
        assertEquals(12, App.wordScoreCalculator("common"));
    }

    @Test
    public void scrabbleWordCalculator_edgeCases() {
        assertEquals(0, App.wordScoreCalculator(""));
        assertEquals(0, App.wordScoreCalculator("          "));
        assertEquals(0, App.wordScoreCalculator("     12-183     "));

        assertEquals(10, App.wordScoreCalculator("v2ery"));
        assertEquals(10, App.wordScoreCalculator("Very"));
        assertEquals(10, App.wordScoreCalculator("VeRy"));
        assertEquals(10, App.wordScoreCalculator("VERY"));
        assertEquals(10, App.wordScoreCalculator("ver!y"));
        assertEquals(10, App.wordScoreCalculator("ver!y"));
        assertEquals(10, App.wordScoreCalculator("  ve ry"));
        assertEquals(10, App.wordScoreCalculator("  ve ry"));
        assertEquals(7, App.wordScoreCalculator("dadd"));
    }
}
