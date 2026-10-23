package problemdomain;

public class SUV extends Vehicle {

    // constructor for SUV subclass
    public SUV(long carID, String VehicleType, String subType, int speed, double fuel, int seats, int year, String drivetrain, int price, int quantity) {
        super(carID, VehicleType, subType, speed, fuel, seats, year, drivetrain, price, quantity);
    }

    // override the 3 abstract Vehicle methods
    public boolean isAvailable() {
        if (getQuantity() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void purchase() {
        System.out.println("Purchase made");
    }

    public String toString() {
        return "";
    }


}
