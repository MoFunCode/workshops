package com.dealership;
/**
 * DealershipFileManager.java
 *
 * This class is responsible for handling file input and output operations related to the dealership inventory.
 *
 * Responsibilities:
 * - Read dealership data from a CSV file and create a Dealership object.
 * - Write dealership data back to the CSV file.
 *
 * File Format (pipe-delimited CSV):
 * - First line contains dealership information in the format:
 *     name|address|phone
 *
 * - Subsequent lines represent vehicle entries in the format:
 *     vin|year|make|model|type|color|mileage|price
 *
 * Notes:
 * - This class ensures data persistence between program runs.
 * - Proper parsing and error handling should be implemented when reading or writing files.
 */

public class DealershipFileManager {
}
