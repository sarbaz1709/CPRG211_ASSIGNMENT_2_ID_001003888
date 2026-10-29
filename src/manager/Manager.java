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

    // create the list of vehicles of type "Vehicle" --> polymorphism will allow us to store different vehicleType inside
    private ArrayList<Vehicle> vehicles = new ArrayList<>();

    // method that reads vehicles.txt and parses into a single list
    public void loadVehicleList() {

        // need to put the file reading scanner in a try/catch statement to handle file errors
        try {
            // create scanner called fileReader, read all the lines and split them by ";"
            // create vehicle objects with those parts and add it to list of vehicles
            Scanner fileReader = new Scanner(new File("res/vehicles.txt"));
            while (fileReader.hasNextLine()) {
                // while there is a next line to read for the fileReader object do this:
                String vehicleLine = fileReader.nextLine();

                // handle cases where the line in vehicle.txt is empty (not needed technically)
                // just good practice for if there is empty line or someone hits "Enter" at the end of the txt file
                if (vehicleLine.trim().isEmpty()) {
                    continue;
                }

                // split the read line into list of the 10 common attribute of all vehicle types
                String[] vehicleLineParts = vehicleLine.split(";");

                // parse and store those common attributes into their respective variables
                long carID = Long.parseLong(vehicleLineParts[0].trim());
                String vehicleType = vehicleLineParts[1].trim();
                String subType = vehicleLineParts[2].trim();
                int speed = Integer.parseInt(vehicleLineParts[3].trim());
                double fuel = Double.parseDouble(vehicleLineParts[4].trim());
                int seats = Integer.parseInt(vehicleLineParts[5].trim());
                int year = Integer.parseInt(vehicleLineParts[6].trim());
                String driveTrain = vehicleLineParts[7].trim();
                int price = Integer.parseInt(vehicleLineParts[8].trim());
                int quantity = Integer.parseInt(vehicleLineParts[9].trim());

                // then depending on the vehicle type, parse and store the extra attributes of that type in their respective variables
                // and create object of that vehicle type, store it in the list "vehicles" of "Vehicle" type
                // note that we can't do this step outside since the variables inside if/else statements are local to it
                if (vehicleType.equals("Sedan")) {
                    char trunkSize = vehicleLineParts[10].trim().charAt(0);
                    vehicles.add(new Sedan(carID, vehicleType, subType, speed, fuel, seats, year, driveTrain, price, quantity, trunkSize));
                } else if (vehicleType.equals("Hatchback")) {
                    char hatchType = vehicleLineParts[10].trim().charAt(0);
                    vehicles.add(new Hatchback(carID, vehicleType, subType, speed, fuel, seats, year, driveTrain, price, quantity, hatchType));
                } else if (vehicleType.equals("Pickup Truck")) {
                    String cargoBedType = vehicleLineParts[10].trim();
                    int cargoCapacity = Integer.parseInt(vehicleLineParts[11].trim());
                    vehicles.add(new PickupTruck(carID, vehicleType,subType, speed, fuel, seats, year, driveTrain, price, quantity, cargoBedType, cargoCapacity));
                } else if (vehicleType.equals("Hybrid")) {
                    String powerTrain = vehicleLineParts[10].trim();
                    int electricRange = Integer.parseInt(vehicleLineParts[11].trim());
                    vehicles.add(new Hybrid(carID, vehicleType, subType, speed, fuel, seats, year, driveTrain, price, quantity, powerTrain, electricRange));
                } else if (vehicleType.equals("SUV")) {
                    vehicles.add(new SUV(carID, vehicleType, subType, speed, fuel, seats, year, driveTrain, price, quantity));
                }
                // next create objects of each vehicle type and store it in list "vehicles"
                /* note to self: the concept of polymorphism is being applied here since vehicles array is of "Vehicle" type
                yet, it stores many different types of vehicles... we can call the same methods on Vehicle but get unique results for each vehicle type
                */
            }
            System.out.println(vehicles);
        } catch (FileNotFoundException error) {
            System.out.println("Couldn't find the file!");
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
