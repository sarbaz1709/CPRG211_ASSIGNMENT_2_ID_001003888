package problemdomain;

public class PickupTruck extends Vehicle {

    // extra fields/attributes of the PickupTruck subclass
    private String CargoBedType;
    private int CargoCapacity;

    // constructor for PickupTruck subclass
    public PickupTruck(long carID, String VehicleType, String subType, int speed, double fuel, int seats, int year, String drivetrain, int price, int quantity, String CargoBedType, int CargoCapacity) {
        super(carID, VehicleType, subType, speed, fuel, seats, year, drivetrain, price, quantity);
        this.CargoBedType = CargoBedType;
        this.CargoCapacity = CargoCapacity;
    }

    // overriding the 3 abstract Vehicle methods

    @Override
    public boolean isAvailable() {
        if (getQuantity() >0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void purchase() {
        System.out.println("Purchase is made");
    }

    @Override
    public String toString() {
        return "";
    }
}
