package com.dealership;
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

        Vehicle myVehicle = new Vehicle("J123LV21", 2002, "Honda", "Accord",
                "Car", "Black", 130345,100);

        System.out.println(myVehicle);



    }

}
