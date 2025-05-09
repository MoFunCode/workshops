package com.dealership;

import java.util.ArrayList;

/**
 * Dealership.java
 * <p>
 * This class represents a car dealership and its inventory system.
 * <p>
 * Responsibilities:
 * - Maintain basic dealership information such as:
 * - Name
 * - Address
 * - Phone number
 * <p>
 * - Manage a collection of Vehicle objects using an ArrayList.
 * <p>
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

    private final ArrayList<Vehicle> vehicleInventory;

    public Dealership() {
        this.vehicleInventory = new ArrayList<Vehicle>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicleInventory.add(vehicle);
    }

    public ArrayList<Vehicle> getAllVehicles() {
        return new ArrayList<Vehicle>(vehicleInventory);
    }

    public Vehicle getVehicleByVIN(String vin) {
        return null;
    }

    public ArrayList<Vehicle> getVehiclesByMake(String make) {
        return null;
    }

    public ArrayList<Vehicle> getVehiclesByModel(String model) {
        return null;
    }

    public ArrayList<Vehicle> getVehiclesByYear(int year) {
        return null;
    }

    public ArrayList<Vehicle> getVehiclesByColor(String color) {
        return null;
    }

    public ArrayList<Vehicle> getVehiclesByMileage(int minMileage, int maxMileage) {
        return null;
    }

    public ArrayList<Vehicle> getVehiclesByType(String vehicleType) {
        return null;
    }

    public ArrayList<Vehicle> getVehiclesByPriceRange(double minPrice, double maxPrice) {
        return null;
    }


    public void removeVehicle(String vin) {

    }
}

