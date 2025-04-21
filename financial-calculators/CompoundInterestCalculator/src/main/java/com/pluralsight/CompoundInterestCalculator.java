package com.pluralsight;

import java.util.Scanner;

public class CompoundInterestCalculator {

    /*
     * This program calculates the future value of a one-time deposit using daily compounding interest.
     *
     * You input:
     * - how much money you're depositing (principal)
     * - the interest rate (like 1.75%)
     * - and how many years you’ll keep it in the bank.
     *
     * The program uses this formula:
     *   FV = P × (1 + r/365)^(365 × t)
     * where:
     * - FV is the future value
     * - P is the principal (your original deposit)
     * - r is the annual interest rate (in decimal form)
     * - t is the number of years
     *
     * Then it tells you how much money you’ll have at the end
     * and how much of that is interest earned.
     */

    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Ask the user to enter how much money they want to deposit
        System.out.print("Enter the deposit amount: $");
        double principal = scanner.nextDouble(); // Store that value in the 'principal' variable

        // Ask the user for the annual interest rate (like 1.75 for 1.75%)
        System.out.print("Enter the annual interest rate (e.g., 1.75 for 1.75%): ");
        double annualRatePercent = scanner.nextDouble(); // Save the input as a percentage

        // Convert the percent to a decimal. Example: 1.75% becomes 0.0175
        double annualRateDecimal = annualRatePercent / 100;

        // Ask how many years the money will stay in the account
        System.out.print("Enter the number of years: ");
        int years = scanner.nextInt();

        // Daily compounding means interest is calculated 365 times per year
        int daysPerYear = 365;

        // Now we apply the compound interest formula
        // Math.pow(x, y) means x raised to the power of y
        double futureValue = principal * Math.pow(1 + (annualRateDecimal / daysPerYear), daysPerYear * years);

        // The total interest is just how much the future value grew beyond the original deposit
        double totalInterest = futureValue - principal;
        // Show the user the results formatted to 2 decimal places
        System.out.printf("Your CD's ending balance will be: $%.2f%n", futureValue);
        System.out.printf("Total interest earned: $%.2f%n", totalInterest);

        // Always good to close the scanner when you're done with it
        scanner.close();
    }
}


