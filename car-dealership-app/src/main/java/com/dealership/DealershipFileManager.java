package com.dealership;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * DealershipFileManager.java
 * <p>
 * This class is responsible for handling file input and output operations related to the dealership inventory.
 * <p>
 * Responsibilities:
 * - Read dealership data from a CSV file and create a Dealership object.
 * - Write dealership data back to the CSV file.
 * <p>
 * File Format (pipe-delimited CSV):
 * - First line contains dealership information in the format:
 * name|address|phone
 * <p>
 * - Subsequent lines represent vehicle entries in the format:
 * vin|year|make|model|type|color|mileage|price
 * <p>
 * Notes:
 * - This class ensures data persistence between program runs.
 * - Proper parsing and error handling should be implemented when reading or writing files.
 */

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

        return dealership; // Return the fully loaded dealership
    }
}
