package com.linkedin.javacodechallenges;

import java.util.Scanner;

public class App {

    //atleast six characters
    //one upper case letter
    //one lowercase letter
    //one number
    public static boolean isPasswordComplex(String password) {

        if(password.length()<6 ){
            return false;
        }

        boolean hasLowerCaseLetter = false;
        boolean hasUpperCaseLetter = false;
        boolean hasNumber = false;

        for(int i=0; i<password.length() || !hasLowerCaseLetter 
        && !hasUpperCaseLetter && !hasNumber; i++) {
            char present = password.charAt(i);
            if(Character.isDigit(present)){
                hasNumber = true;
            } else if (Character.isUpperCase(present)){
                hasUpperCaseLetter = true;
            } else if (Character.isLowerCase(present)) {
                hasLowerCaseLetter = true;
            }
        }
        
        return hasLowerCaseLetter && hasUpperCaseLetter && hasNumber;
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
