package com.dealership;

import java.util.ArrayList;

/**
 * Program.java
 *
 * This is the entry point of the application.
 *
 * Responsibilities:
 * - Contain the main() method.
 * - Create an instance of the UserInterface class.
 * - Start the dealership application by calling the appropriate method in UserInterface.
 *
 * Notes:
 * - This class should remain minimal and only handle application startup logic.
 */


public class Program {

    public static void main(String[] args) {

        Dealership dealership = new Dealership();

        Vehicle car1 = new Vehicle("VIN123", 2020, "Toyota", "Camry", "Sedan", "Black", 25000, 22000.0);
        dealership.addVehicle(car1);

        ArrayList<Vehicle> allCars = dealership.getAllVehicles();
        System.out.println("All cars: " + allCars);
    }

    }

