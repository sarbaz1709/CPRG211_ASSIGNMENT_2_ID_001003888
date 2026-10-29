package app;

// import Manager class from manager package
import manager.Manager;

// import all the classes from problemdomain package
import problemdomain.Vehicle;
import problemdomain.SUV;
import problemdomain.Sedan;
import problemdomain.PickupTruck;
import problemdomain.Hybrid;
import problemdomain.Hatchback;


public class App {
    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.loadVehicleList();
    }
}
