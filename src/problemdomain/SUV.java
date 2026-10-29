package problemdomain;

public class SUV extends Vehicle {

    // constructor for SUV subclass
    public SUV(long carID, String vehicleType, String subType, int speed, double fuel, int seats, int year, String driveTrain, int price, int quantity) {
        super(carID, vehicleType, subType, speed, fuel, seats, year, driveTrain, price, quantity);
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
        return "SUV";
    }


}
