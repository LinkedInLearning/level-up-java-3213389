package com.linkedin.javacodechallenges;

import java.util.Scanner;

public class App {

    //atleast six characters
    //one upper case letter
    //one lowercase letter
    //one number
    public static boolean isPasswordComplex(String password) {

        return password.length() >=6 
            && password.matches(".*\\d.*")
            && password.matches(".*[a-z].*")
            && password.matches(".*[A-Z].*");

        // n
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a password: ");
        String userInput = scanner.nextLine();
        System.out.println("Is the password complex? "
                + isPasswordComplex(userInput));

        scanner.close();
    }
}
