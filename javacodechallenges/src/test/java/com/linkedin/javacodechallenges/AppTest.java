package com.linkedin.javacodechallenges;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class AppTest {
    
    @Test
    public void isEven_true() {
        assertTrue(App.isEven(0));
        assertTrue(App.isEven(2));
        assertTrue(App.isEven(4));
        assertTrue(App.isEven(6));
        assertTrue(App.isEven(8));
        assertTrue(App.isEven(-20));
        assertTrue(App.isEven(100));
        assertTrue(App.isEven(-46));
    }

    @Test
    public void isEven_false() {
        assertFalse(App.isEven(1));
        assertFalse(App.isEven(3));
        assertFalse(App.isEven(5));
        assertFalse(App.isEven(7));
        assertFalse(App.isEven(9));
        assertFalse(App.isEven(-11));
        assertFalse(App.isEven(93));
        assertFalse(App.isEven(-75));
    }
}
