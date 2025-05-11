package com.dealership;

import java.util.ArrayList;

/**
 * Dealership.java
 * This class represents a car dealership and its inventory system.
 * Responsibilities:
 * - Maintain basic dealership information such as:
 * - Name
 * - Address
 * - Phone number
 * - Manage a collection of Vehicle objects using an ArrayList.
 * - Provide functionality to:
 * - Add a vehicle to the inventory.
 * - Remove a vehicle from the inventory.
 * - Retrieve a list of all vehicles in the inventory.
 * - Search for vehicles based on:
 * - Price range
 * - Make and/or model
 * - Year range
 * - Color
 * - Mileage
 * - Vehicle type (e.g., SUV, truck, car, van)
 */

public class Dealership {

    private final ArrayList<Vehicle> inventory;
    private final String name;
    private final String address;
    private final String phone;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public ArrayList<Vehicle> getAllVehicles() {
        return new ArrayList<>(inventory); // Defensive copy
    }

    public ArrayList<Vehicle> getVehiclesByPrice(double min, double max) {
        return null;
    }

    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) {
        return null;
    }

    public ArrayList<Vehicle> getVehiclesByYear(int min, int max) {
        return null;
    }

    public ArrayList<Vehicle> getVehiclesByColor(String color) {
        return null;
    }

    public ArrayList<Vehicle> getVehiclesByMileage(int min, int max) {
        return null;
    }

    public ArrayList<Vehicle> getVehiclesByType(String vehicleType) {
        return null;
    }

    public void removeVehicle(Vehicle vehicle) {
    }
}

