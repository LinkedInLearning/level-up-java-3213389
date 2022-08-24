package com.linkedin.javacodechallenges;

public class App 
{
    public static LocalDate calculateHundredDaysFromNow(LocalDate today) {
        Period hundredDays = Period.ofDays(100);
        return today.plus(hundredDays);
    }

    public static void main( String[] args )
    {
        LocalDate today = LocalDate.now(ZoneId.of("America/New_York"));
        System.out.println("100 days from now is... " +
            calculateHundredDaysFromNow(today));
    }
}
