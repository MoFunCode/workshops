package com.dealership;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * UserInterface.java
 * <p>
 * This class manages the interaction between the user and the dealership application.
 * <p>
 * Responsibilities:
 * - Display the main menu and any sub-menus to the user.
 * - Read and process user input.
 * - Dispatch user-selected commands to appropriate methods in the Dealership class.
 * <p>
 * Key Functional Methods:
 * - Process vehicle searches based on various criteria, such as:
 * - Price range
 * - Make and/or model
 * - Year range
 * - Color
 * - Mileage
 * - Type (car, truck, SUV, van)
 * <p>
 * - Handle adding a new vehicle to the inventory.
 * - Handle removing a vehicle from the inventory.
 * - Display search results or inventory lists to the user in a readable format.
 * <p>
 * Notes:
 * - Input validation and user guidance should be implemented for a smooth experience.
 * - This class acts as the main control hub for user-driven actions.
 */


public class UserInterface {

    private Dealership dealership;
    private final Scanner scanner;
    private final DealershipFileManager fileManager;

    public UserInterface() {
        scanner = new Scanner(System.in);
        fileManager = new DealershipFileManager();
    }

    private void init() {
        dealership = fileManager.getDealership();
        if (dealership == null) {
            System.out.println("Error: Could not load dealership data.");
            System.exit(1);
        }
    }

    public void display() {
        init();

        boolean exit = false;
        while (!exit) {
            displayMenu();

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1 -> processGetByPriceRequest();
                case 2 -> processGetByMakeModelRequest();
                case 3 -> processGetByYearRequest();
                case 4 -> processGetByColorRequest();
                case 5 -> processGetByMileageRequest();
                case 6 -> processGetByVehicleTypeRequest();
                case 7 -> processAllVehiclesRequest();
                case 8 -> processAddVehicleRequest();
                case 9 -> processRemoveVehicleRequest();
                case 99 -> {
                    System.out.println("Thank you for using the dealership application. Take care of yourself!");
                    exit = true;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    private void displayMenu() {
        System.out.println("\n" + dealership.getName() + " - Dealership Management System");
        System.out.println("--------------------------------------------");
        System.out.println("1 - Find vehicles within a price range");
        System.out.println("2 - Find vehicles by make/model");
        System.out.println("3 - Find vehicles by year range");
        System.out.println("4 - Find vehicles by color");
        System.out.println("5 - Find vehicles by mileage range");
        System.out.println("6 - Find vehicles by type (car, truck, SUV, van)");
        System.out.println("7 - List ALL vehicles");
        System.out.println("8 - Add a vehicle");
        System.out.println("9 - Remove a vehicle");
        System.out.println("99 - Quit");
        System.out.print("\nEnter your choice: ");
    }

    private void displayVehicles(ArrayList<Vehicle> vehicles) {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found matching your criteria.");
            return;
        }

        System.out.println("\nMatching Vehicles:");
        System.out.println("------------------");
        for (int i = 0; i < vehicles.size(); i++) {
            System.out.println((i + 1) + ". " + vehicles.get(i));
        }
        System.out.println("------------------");
        System.out.println("Total vehicles: " + vehicles.size());
    }

    private void processAllVehiclesRequest() {
        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);
    }

    private void processGetByPriceRequest() {
        System.out.print("Enter minimum price: $");
        double min = Double.parseDouble(scanner.nextLine().trim());

        System.out.print("Enter maximum price: $");
        double max = Double.parseDouble(scanner.nextLine().trim());

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByPrice(min, max);
        displayVehicles(vehicles);
    }

    private void processGetByMakeModelRequest() {
        System.out.print("Enter make (or press Enter to skip): ");
        String make = scanner.nextLine().trim();

        System.out.print("Enter model (or press Enter to skip): ");
        String model = scanner.nextLine().trim();

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByMakeModel(make, model);
        displayVehicles(vehicles);
    }

    private void processGetByYearRequest() {
        System.out.print("Enter minimum year: ");
        int min = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Enter maximum year: ");
        int max = Integer.parseInt(scanner.nextLine().trim());

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByYear(min, max);
        displayVehicles(vehicles);
    }

    private void processGetByColorRequest() {
        System.out.print("Enter color: ");
        String color = scanner.nextLine().trim();

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByColor(color);
        displayVehicles(vehicles);
    }

    private void processGetByMileageRequest() {
        System.out.print("Enter minimum mileage: ");
        int min = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Enter maximum mileage: ");
        int max = Integer.parseInt(scanner.nextLine().trim());

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByMileage(min, max);
        displayVehicles(vehicles);
    }

    private void processGetByVehicleTypeRequest() {
        System.out.print("Enter vehicle type (car, truck, SUV, van): ");
        String type = scanner.nextLine().trim();

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByType(type);
        displayVehicles(vehicles);
    }

    private void processAddVehicleRequest() {
        try {
            System.out.println("\nAdd New Vehicle");
            System.out.println("--------------");

            System.out.print("Enter VIN: ");
            int vin = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Enter year: ");
            int year = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Enter make: ");
            String make = scanner.nextLine().trim();

            System.out.print("Enter model: ");
            String model = scanner.nextLine().trim();

            System.out.print("Enter vehicle type (car, truck, SUV, van): ");
            String vehicleType = scanner.nextLine().trim();

            System.out.print("Enter color: ");
            String color = scanner.nextLine().trim();

            System.out.print("Enter odometer reading: ");
            int odometer = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Enter price: $");
            double price = Double.parseDouble(scanner.nextLine().trim());

            Vehicle newVehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
            dealership.addVehicle(newVehicle);

            fileManager.saveDealership(dealership);

            System.out.println("Vehicle added successfully!");

        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid input. Vehicle not added.");
        }
    }

    private void processRemoveVehicleRequest() {
        ArrayList<Vehicle> allVehicles = dealership.getAllVehicles();

        if (allVehicles.isEmpty()) {
            System.out.println("No vehicles available to remove.");
            return;
        }

        System.out.println("\nSelect a vehicle to remove:");
        displayVehicles(allVehicles);

        System.out.print("\nEnter the number of the vehicle you want to remove: ");
        try {
            int choice = Integer.parseInt(scanner.nextLine().trim());

            if (choice < 1 || choice > allVehicles.size()) {
                System.out.println("Invalid selection.");
                return;
            }

            Vehicle vehicleToRemove = allVehicles.get(choice - 1);
            dealership.removeVehicle(vehicleToRemove);

            fileManager.saveDealership(dealership);

            System.out.println("Vehicle removed successfully!");

        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid input.");
        }
    }
}

