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

    @Override
    public void purchase() {
        setQuantity(getQuantity() -1 );
    }

    @Override
    public String toString() {
        // SUV has no extra attributes, so it only shows the common Vehicle details
        return "Car ID:\t\t" + getCarID() +
                "\nVehicle Type:\t" + getVehicleType() +
                "\nSub Type:\t" + getSubType() +
                "\nSpeed:\t\t" + getSpeed() +
                "\nFuel:\t\t" + getFuel() +
                "\nNumber of Seats:\t" + getSeats() +
                "\nYear:\t\t" + getYear() +
                "\nDrivetrain:\t\t" + getDriveTrain() +
                "\nPrice:\t\t" + getPrice() +
                "\nAvailable:\t\t" + getQuantity();
    }


}
