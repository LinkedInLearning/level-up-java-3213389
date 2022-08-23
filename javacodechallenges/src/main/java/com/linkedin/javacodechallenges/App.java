package com.linkedin.javacodechallenges;

import java.util.Scanner;

public class App {

    public static double calculateWaterBill(double gallonsUsage) {
        double minimumWaterBill = 18.84;
        double numberOfGallonsInCCF = 748;
        double includedGallons = 2 * numberOfGallonsInCCF;

        if (gallonsUsage <= includedGallons) {
            return minimumWaterBill;
        } else {
            double extraGallonsUsed = gallonsUsage - includedGallons;
            double extraAmountOwed = Math.ceil(extraGallonsUsed / 
                numberOfGallonsInCCF) * 3.9;
            return minimumWaterBill + extraAmountOwed;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many gallons of water did you " +
                "use this month?");
        double usage = scanner.nextDouble();
        System.out.println("Your water bill is " +
                calculateWaterBill(usage));
        scanner.close();
    }
}
