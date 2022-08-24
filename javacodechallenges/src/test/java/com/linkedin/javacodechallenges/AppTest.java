package com.linkedin.javacodechallenges;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class AppTest {
    @Test
    public void calculateAverageChangeInvested_empty() {
        assertEquals(0,
                App.calculateAverageChangeInvested(List.of()), 0);
    }

    @Test
    public void calculateAverageChangeInvested_oneItem() {
        assertEquals(0.75,
                App.calculateAverageChangeInvested(List.of(19.25)), 0);
    }

    @Test
    public void calculateAverageChangeInvested() {
        List<Double> purchases = List.of(12.38, 38.29, 5.27, 3.21);
        double estimatedAverageChangeInvested = ((13 - 12.38) + (39 - 38.29) +
                (6 - 5.27) + (4 - 3.21)) / 4;
        assertEquals(estimatedAverageChangeInvested,
                App.calculateAverageChangeInvested(purchases), 0);

        purchases = List.of(19.99, 19.95, 29.95, 39.95, 19.99);
        estimatedAverageChangeInvested = ((20 - 19.99) + (20 - 19.95) +
                (30 - 29.95) + (40 - 39.95) + (20 - 19.99)) / 5;
        assertEquals(estimatedAverageChangeInvested,
                App.calculateAverageChangeInvested(purchases), 0);
    }
}
