package com.linkedin.javacodechallenges;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AppTest {

    @Test
    public void calculateWaterBill() {
        assertEquals(22.74, App.calculateWaterBill(1800), 0);
        assertEquals(22.74, App.calculateWaterBill(2244), 0);
        assertEquals(26.64, App.calculateWaterBill(2245), 0);
        assertEquals(26.64, App.calculateWaterBill(2992), 0);
        assertEquals(46.14, App.calculateWaterBill(6000), 0);
        assertEquals(53.94, App.calculateWaterBill(8000), 0);

        assertEquals(18.84, App.calculateWaterBill(0), 0);
        assertEquals(18.84, App.calculateWaterBill(1496), 0);
        assertEquals(22.74, App.calculateWaterBill(1497), 0);
        assertEquals(18.84, App.calculateWaterBill(-20), 0);
    }
}