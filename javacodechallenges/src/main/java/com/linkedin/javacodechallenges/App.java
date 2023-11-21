package com.linkedin.javacodechallenges;

import java.util.Scanner;
import java.util.regex.Pattern;

public class App {

    public static boolean isPasswordComplex(String password) {
    
        // if(password.length()>= 6){
            
        //     return Pattern.matches("[\\w\\W\\s]*", password);
        //     }
        // return false;

        return password.length()>=6 && password.matches(".*\\d.*")&& password.matches(".*[a-z].*")
        && password.matches(".*[A-Z].*");
        // if(password.length()<6){
        //     return false;
        // }

        // boolean hasLowercaseLetter = false;
        // boolean hasUppercaseLetter = false;
        // boolean hasNumber = false;

        // for( int i=0; i < password.length() || !hasLowercaseLetter && !hasUppercaseLetter && !hasNumber;i++){
        //   char current = password.charAt(i);
        //   if(Character.isDigit(current)){
        //     hasNumber = true;
        //   }
        //   else if(Character.isLowerCase(current)){
        //     hasLowercaseLetter = true;
        //   }  else if(Character.isUpperCase(current)){
        //     hasUppercaseLetter = true;
        //   } 
        // }
        // return hasNumber && hasLowercaseLetter && hasUppercaseLetter ;
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
