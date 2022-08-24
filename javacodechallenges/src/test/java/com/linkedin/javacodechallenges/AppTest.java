package com.linkedin.javacodechallenges;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

public class AppTest {

    @Test
    public void calculateHundredDaysFromNow() {
        LocalDate d1 = LocalDate.of(2020, 1, 1);
        assertEquals(LocalDate.of(2020, 4, 10),
                App.calculateHundredDaysFromNow(d1));

        LocalDate d2 = LocalDate.of(2020, 11, 6);
        assertEquals(LocalDate.of(2021, 2, 14),
                App.calculateHundredDaysFromNow(d2));

        LocalDate d3 = LocalDate.of(2022, 11, 8);
        assertEquals(LocalDate.of(2023, 2, 16),
                App.calculateHundredDaysFromNow(d3));
    }
}
