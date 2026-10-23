package manager;

// import all the classes from problemdomain
import problemdomain.Vehicle;
import problemdomain.SUV;
import problemdomain.Sedan;
import problemdomain.PickupTruck;
import problemdomain.Hybrid;
import problemdomain.Hatchback;

// import the needed utilities
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;


public class Manager {

    // method that reads vehicles.txt and parses into a single list
    public void loadVehicleList() {

        // need to put the file reading scanner in a try/catch statement to handle file errors
        try {
            // create scanner called fileReader, read all the lines and split them by ";"
            // create vehicle objects with those parts and add it to list of vehicles
            Scanner fileReader = new Scanner(new File("res/vehicles.txt"));
            while (fileReader.hasNextLine()) {
                String vehicleLine = fileReader.nextLine();
                String[] vehicleLineParts = vehicleLine.split(";");

            }
        } catch (FileNotFoundException error) {
            System.out.println("Couldn't find the file!");;
        }
    }




    // method that allows customer to purchase a vehicle


    // method that prompts a customer to enter vehicle type, performs case-insensitive search, and displays all vehicles of that type


    // method that prompts a customer enter a vehicle type and corresponding type specific attribute
    // performs a case in-sensitive search and displays all vehicles of that type and type specific attribute


    // method that prompts customer to enter number and displays that number of randomly selected vehicles


    // method that saves the vehicles stored in the list back to vehicles.txt in the original format
    // upon exiting the program


}
