package com.linkedin.javacodechallenges;

import java.time.LocalDate;

public class App 
{
    // Create function to calculate the date that's 
    // 100 days from now

    public static void main( String[] args ){

        LocalDate today = LocalDate.now();
        LocalDate futureDate = today.plusDays(100);

        System.out.println("Today's date: " + today);
        System.out.println("100 days from now is... " + futureDate);
    }
}
