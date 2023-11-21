package com.linkedin.javacodechallenges;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void isPasswordComplex_true() {
        assertTrue(App.isPasswordComplex("Happy12"));
        assertTrue(App.isPasswordComplex("1SarahL ength"));
        assertTrue(App.isPasswordComplex("Password12"));
        assertTrue(App.isPasswordComplex("2PassW@ord1"));
        assertTrue(App.isPasswordComplex("01Sall#y9"));
    }

    @Test
    public void isPasswordComplex_false() {
        assertFalse(App.isPasswordComplex("12aB "));
        assertFalse(App.isPasswordComplex("Ab112"));
        assertFalse(App.isPasswordComplex("happy"));
        assertFalse(App.isPasswordComplex("happy_1"));
        assertFalse(App.isPasswordComplex("p assword12"));
        assertFalse(App.isPasswordComplex("Sur18"));
        assertFalse(App.isPasswordComplex(""));
    }
}
