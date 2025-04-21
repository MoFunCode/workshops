package com.pluralsight;

import java.util.Scanner;

public class MortgageCalculator {

    public static void main(String[] args) {
        // Create Scanner object to read user input from console
        Scanner scanner = new Scanner(System.in);

        // Prompt user for loan details and store their inputs
        System.out.print("Enter the loan amount (principal): ");
        double principal = scanner.nextDouble();  // Store the amount borrowed

        System.out.print("Enter the annual interest rate (e.g., 7.625): ");
        double annualInterestRate = scanner.nextDouble();  // Store interest as percentage (like 7.625)

        System.out.print("Enter the loan term in years: ");
        int years = scanner.nextInt();  // Store loan duration in years

        // Convert annual values to monthly for the formula
        // Divide by 100 to convert from percentage to decimal, then by 12 for monthly rate
        double monthlyInterestRate = annualInterestRate / 100 / 12;

        // Calculate total number of monthly payments over the loan term
        int totalPayments = years * 12;  // Example: 30 years = 360 payments
        // Apply standard mortgage payment formula:
        // M = P [ r(1+r)^n / ((1+r)^n - 1) ]
        // Where: M = monthly payment, P = principal, r = monthly interest rate, n = total payments
        double monthlyPayment = principal *
                (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, totalPayments)) /  // Numerator
                (Math.pow(1 + monthlyInterestRate, totalPayments) - 1);  // Denominator

        // Calculate total amount paid over life of loan (monthly payment × number of payments)
        double totalPaid = monthlyPayment * totalPayments;

        // Calculate total interest paid (total amount paid minus the original principal)
        double totalInterest = totalPaid - principal;

        // Format and print the monthly payment amount with 2 decimal places
        System.out.printf("Your monthly payment is: $%.2f\n", monthlyPayment);

        // Format and print the total interest paid over the life of the loan
        System.out.printf("Total interest paid over the life of the loan: $%.2f\n", totalInterest);

        // Close the scanner is always a good practice
        scanner.close();


    }
}

