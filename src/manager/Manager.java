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
import java.io.PrintWriter;
import java.util.Collections;


public class Manager {

    // create the master list of vehicles of type "Vehicle" --> polymorphism will allow us to store different vehicleType inside
    private ArrayList<Vehicle> vehicles = new ArrayList<>();

    // create a scanner for user input to be used later (this is different from the fileReader scanner below)
    Scanner scanner = new Scanner(System.in);

    // method that reads vehicles.txt and parses into list "vehicles" of type "Vehicle"
    public void loadVehicleList() {

        // need to put the file reading code in a try/catch statement to handle file errors
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

                // also get the first digit of the carID so that we can do the condition check below
                char firstDigit = vehicleLineParts[0].trim().charAt(0);

                // then depending on the vehicle type, parse and store the extra attributes of that type in their respective variables
                // and create object of that vehicle type, store it in the list "vehicles" of "Vehicle" type
                // note that we can't do this step outside since the variables like trunkSize inside if/else statements are local to it
                if (firstDigit == '1') { // 1 == Sedan
                    char trunkSize = vehicleLineParts[10].trim().charAt(0);
                    vehicles.add(new Sedan(carID, vehicleType, subType, speed, fuel, seats, year, driveTrain, price, quantity, trunkSize));
                } else if (firstDigit == '2') { // 2 == Hatchback
                    char hatchType = vehicleLineParts[10].trim().charAt(0);
                    vehicles.add(new Hatchback(carID, vehicleType, subType, speed, fuel, seats, year, driveTrain, price, quantity, hatchType));
                } else if (firstDigit == '3') { // 3 == SUV
                    vehicles.add(new SUV(carID, vehicleType, subType, speed, fuel, seats, year, driveTrain, price, quantity));
                } else if (firstDigit == '4' || firstDigit == '5') { // 4 or 5 == Hybrid
                    String powerTrain = vehicleLineParts[10].trim();
                    int electricRange = Integer.parseInt(vehicleLineParts[11].trim());
                    vehicles.add(new Hybrid(carID, vehicleType, subType, speed, fuel, seats, year, driveTrain, price, quantity, powerTrain, electricRange));
                } else if (firstDigit == '6') { // 6 == PickupTruck
                    String cargoBedType = vehicleLineParts[10].trim();
                    int cargoCapacity = Integer.parseInt(vehicleLineParts[11].trim());
                    vehicles.add(new PickupTruck(carID, vehicleType,subType, speed, fuel, seats, year, driveTrain, price, quantity, cargoBedType, cargoCapacity));
                }
                // now we have an ArrayList "vehicles" of superclass Vehicle type with different subclass vehicles inside of it

                /* note to self: the concept of polymorphism is being applied here since vehicles array is of "Vehicle" type
                yet, it stores many different subclass of Vehicle objects... we can call the same methods on Vehicle but get unique results for each subclass vehicle
                */
            }
            System.out.println(vehicles); // note for later: modify toString override of all vehicle subclass to fix this output
        // catch errors if you can't find the file (have to do this when reading a file)
        // or optionally throw it to App.java where you can catch it when the method loadVehicleList is called (here we did the former)
        } catch (FileNotFoundException error) {
            System.out.println("Couldn't find the file!");
        }
    }

    // method that allows customer to purchase a vehicle
    public void purchaseVehicle() {
        System.out.print("Enter CarID: "); // prompt user to enter a car id
        try {
            int carID = Integer.parseInt(scanner.nextLine()); // store it in carID variable

            boolean vehicleFound = false;  // break condition of the loop
            for (Vehicle vehicle : vehicles) { // iterate through the list of vehicle objects
                if (vehicle.getCarID() == carID) { // if a matching car ID is found
                    String vehicleName = vehicle.getVehicleType() + " " + vehicle.getSubType(); // store its name and subtype

                    if (vehicle.isAvailable()) { // if it is available (the isAvailable method returns true or false depending on quantity)
                        vehicle.purchase();      // use the purchase() method to decrease quantity
                        System.out.println("The Vehicle " + vehicleName + " has been purchased.");
                    } else { // otherwise say its not available
                        System.out.println("The Vehicle " + vehicleName + " is not available.");
                    }
                }
                vehicleFound = true;
                break;
            }
            if (!vehicleFound) {
                System.out.println("No vehicle found with CarID " + carID + ".");
            }
        } catch (NumberFormatException error) {
            System.out.println("Invalid CarID. Please enter numbers only.");
        }
    }

    // method that prompts a customer to enter vehicle type, performs case-insensitive search, and displays all vehicles of that type
    // method that prompts a customer to enter vehicle type, performs case-insensitive search, and displays all vehicles of that type
    public void displayVehiclesByType() {
        System.out.print("Enter vehicle type to search for: (Sedan, SUV, Hatchback, Pickup Truck and Hybrid) ");
        String searchType = scanner.nextLine().trim();

        System.out.println("Matching vehicles:");
        boolean found = false;
        for (Vehicle vehicle : vehicles) {
            // equalsIgnoreCase makes the search case-insensitive ("sedan" == "Sedan" == "SEDAN")
            if (vehicle.getVehicleType().equalsIgnoreCase(searchType)) {
                System.out.println(vehicle); // calls the overridden toString() of that subclass (polymorphism)
                System.out.println();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No vehicles found of type \"" + searchType + "\".");
            System.out.println();
        }
    }


    // method that prompts a customer enter a vehicle type and corresponding type specific attribute
    // performs a case in-sensitive search and displays all vehicles of that type and type specific attribute
    public void displayVehiclesByTypeSpecificAttribute() {
        System.out.println("#\tVehicle Type");
        System.out.println("1\tSedan");
        System.out.println("2\tHatchback");
        System.out.println("3\tSUV");
        System.out.println("4\tHybrid");
        System.out.println("5\tPickup Truck");
        System.out.println();
        System.out.print("Enter type of vehicle: ");
        String typeChoice = scanner.nextLine().trim();

        // ask for the attribute that matches the chosen vehicle type
        switch (typeChoice) {
            case "1":
                System.out.print("Enter trunk size (L for Large/Spacious Trunk, S for Small Trunk, or M for Moderate Trunk): ");
                break;
            case "2":
                System.out.print("Enter hatch type (S for Standard Liftgate, T for Split Liftgate, P for Power Liftgate): ");
                break;
            case "3":
                System.out.print("Enter drivetrain (AWD for All Wheel Drive, 4WD for Four Wheel Drive): ");
                break;
            case "4":
                System.out.print("Enter a powertrain (E for Series Hybrid, A for Parallel Hybrid, PHEV for Plug-in Hybrid): ");
                break;
            case "5":
                System.out.print("Enter cargo bed type (SB for Short Bed, EB for Extended Bed, or DB for Dump Bed): ");
                break;
            default:
                System.out.println("Invalid option. Please enter a number from 1 to 5.");
                System.out.println();
                return;
        }
        String attribute = scanner.nextLine().trim();
        System.out.println();

        System.out.println("Matching Vehicles:");
        boolean found = false;
        for (Vehicle vehicle : vehicles) {
            boolean isMatch = false;

            // instanceof checks which subclass the vehicle really is
            // then we cast it so we can call the getter that only that subclass has
            if (typeChoice.equals("1") && vehicle instanceof Sedan) {
                Sedan sedan = (Sedan) vehicle;
                // trunkSize is a char, so turn it into a String to use equalsIgnoreCase
                isMatch = String.valueOf(sedan.getTrunkSize()).equalsIgnoreCase(attribute);
            } else if (typeChoice.equals("2") && vehicle instanceof Hatchback) {
                Hatchback hatchback = (Hatchback) vehicle;
                isMatch = String.valueOf(hatchback.getHatchType()).equalsIgnoreCase(attribute);
            } else if (typeChoice.equals("3") && vehicle instanceof SUV) {
                // drivetrain lives in Vehicle, so no cast is needed here
                isMatch = vehicle.getDriveTrain().equalsIgnoreCase(attribute);
            } else if (typeChoice.equals("4") && vehicle instanceof Hybrid) {
                Hybrid hybrid = (Hybrid) vehicle;
                isMatch = hybrid.getPowerTrain().equalsIgnoreCase(attribute);
            } else if (typeChoice.equals("5") && vehicle instanceof PickupTruck) {
                PickupTruck pickupTruck = (PickupTruck) vehicle;
                isMatch = pickupTruck.getCargoBedType().equalsIgnoreCase(attribute);
            }

            if (isMatch) {
                System.out.println(vehicle);
                System.out.println();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching vehicles found.");
            System.out.println();
        }
    }

    // method that prompts customer to enter number and displays that number of randomly selected vehicles
    // method that prompts customer to enter number and displays that number of randomly selected vehicles
    public void displayRandomVehicles() {
        System.out.print("Enter number of vehicles to display: ");

        int numberOfVehicles;
        try {
            numberOfVehicles = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException error) {
            System.out.println();
            System.out.println("Invalid number. Please enter a whole number.");
            System.out.println();
            return;
        }

        if (numberOfVehicles <= 0) {
            System.out.println();
            System.out.println("Please enter a number greater than 0.");
            System.out.println();
            return;
        }

        // can't show more vehicles than we have, so cap it at the list size
        if (numberOfVehicles > vehicles.size()) {
            numberOfVehicles = vehicles.size();
        }
        System.out.println();

        // shuffle a COPY of the list so the original order (which gets saved to the file) stays the same
        ArrayList<Vehicle> shuffledVehicles = new ArrayList<>(vehicles);
        Collections.shuffle(shuffledVehicles);

        System.out.println("Random Vehicles:");
        for (int i = 0; i < numberOfVehicles; i++) {
            System.out.println(shuffledVehicles.get(i));
            System.out.println();
            System.out.println("----------------------------------");
        }
        System.out.println();
    }

    // method that saves the vehicles stored in the list back to vehicles.txt in the original format
    // upon exiting the program
    // method that saves the vehicles stored in the list back to vehicles.txt in the original format
    // upon exiting the program
    public void saveVehicleList() {
        System.out.print("Saving Vehicles...");

        // PrintWriter throws FileNotFoundException just like the Scanner(File) in loadVehicleList
        try {
            PrintWriter fileWriter = new PrintWriter("res/vehicles.txt");
            for (Vehicle vehicle : vehicles) {
                // formatForFile() puts every attribute back into the semicolon format
                fileWriter.println(vehicle.formatForFile());
            }
            fileWriter.close(); // closing the writer is what actually saves everything to the file
            System.out.println(" Done!");
        } catch (FileNotFoundException error) {
            System.out.println(" Couldn't save the file!");
        }
    }

}
