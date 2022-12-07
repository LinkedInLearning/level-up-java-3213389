package com.linkedin.javacodechallenges;

import java.util.Scanner;

public class App {

    public static boolean isPasswordComplex(String password) {
        if (!password.isEmpty() && password != null) {
            char[] passChars = password.trim().toCharArray();
            if (passChars.length >= 6) {
                boolean isUpperLetter = false;
                boolean isLowerLetter = false;
                boolean isNumber = false;
                for(char c: passChars) {
                    if (!isUpperLetter && c >= 'A' && c <= 'Z')
                        isUpperLetter = true;
                    else if (!isLowerLetter && c >= 'a' && c <= 'z')
                        isLowerLetter = true;
                    else if (!isNumber && c >= '0' && c <= '9')
                            isNumber = true;
                    if(isUpperLetter && isLowerLetter && isNumber)
                        return true;
                }
            }
        }
        return false;
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
