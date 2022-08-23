package com.linkedin.javacodechallenges;

public class App 
{
    public static void main( String[] args )
    {
        Person p1 = new Person("Ron", "Freeman", 37);
        Person p2 = new Person("Taylor", "Warren", 29);
        Person p3 = new Person("Sarah", "Ford", 52);

        p1.introduceYourself();
        p2.introduceYourself();
        p3.introduceYourself();
    }
}
