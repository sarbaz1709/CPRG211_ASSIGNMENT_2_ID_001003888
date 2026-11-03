package app;

// import Manager class from manager package
import manager.Manager;

// import Scanner
import java.util.Scanner;


public class App {
    static Manager manager = new Manager(); // create manager class to use the loadVehicle list method
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        manager.loadVehicleList();
        displayMenu();
    }

    // displayMenu method which runs everything
    // shows the main menu and calls the method for the option the user picks
    // keeps looping until the user chooses 5 (Save & Exit)
    public static void displayMenu() {
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Welcome to Drive Masters");
            System.out.println("Please choose any option below");
            System.out.println("---------------------------------");
            System.out.println("1\tPurchase Vehicle");
            System.out.println("2\tDisplay Vehicles by Type");
            System.out.println("3\tDisplay Vehicles by Type-Specific Attribute");
            System.out.println("4\tProduce a Random List of Vehicles");
            System.out.println("5\tSave & Exit");
            System.out.println();
            System.out.print("Enter option: ");
            String option = scanner.nextLine().trim();

            switch (option) {
                case "1":
                    manager.purchaseVehicle();
                    break;
                case "2":
                    manager.displayVehiclesByType();
                    break;
                case "3":
                    manager.displayVehiclesByTypeSpecificAttribute();
                    break;
                case "4":
                    manager.displayRandomVehicles();
                    break;
                case "5":
                    manager.saveVehicleList();
                    System.out.println("Goodbye!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid option. Please enter a number from 1 to 5.");
                    System.out.println();
            }
        }
    }
}
