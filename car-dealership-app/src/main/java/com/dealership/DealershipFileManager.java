package com.dealership;

import java.io.*;
import java.util.ArrayList;


public class DealershipFileManager {

    private static final String INVENTORY_FILE = "src/main/resources/inventory.csv";

    public Dealership getDealership() {
        Dealership dealership = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(INVENTORY_FILE))) {
            String dealershipLine = reader.readLine();

            if (dealershipLine != null) {
                String[] dealershipInfo = dealershipLine.split("\\|");

                dealership = new Dealership(
                        dealershipInfo[0].trim(),
                        dealershipInfo[1].trim(),
                        dealershipInfo[2].trim()
                );

                String vehicleLine;
                while ((vehicleLine = reader.readLine()) != null) {
                    String[] vehicleData = vehicleLine.split("\\|");

                    Vehicle vehicle = new Vehicle(
                            Integer.parseInt(vehicleData[0].trim()),
                            Integer.parseInt(vehicleData[1].trim()),
                            vehicleData[2].trim(),
                            vehicleData[3].trim(),
                            vehicleData[4].trim(),
                            vehicleData[5].trim(),
                            Integer.parseInt(vehicleData[6].trim()),
                            Double.parseDouble(vehicleData[7].trim())
                    );


                    dealership.addVehicle(vehicle);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading inventory file: " + e.getMessage());
            e.printStackTrace();
        }

        return dealership;
    }

    public void saveDealership(Dealership dealership) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(INVENTORY_FILE))) {
            writer.write(String.format("%s|%s|%s",
                    dealership.getName(),
                    dealership.getAddress(),
                    dealership.getPhone()));
            writer.newLine();

            ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
            for (Vehicle vehicle : vehicles) {
                writer.write(String.format("%d|%d|%s|%s|%s|%s|%d|%.2f",
                        vehicle.getVin(),
                        vehicle.getYear(),
                        vehicle.getMake(),
                        vehicle.getModel(),
                        vehicle.getVehicleType(),
                        vehicle.getColor(),
                        vehicle.getOdometer(),
                        vehicle.getPrice()));
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to inventory file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

