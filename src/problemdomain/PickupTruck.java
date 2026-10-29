package problemdomain;

public class PickupTruck extends Vehicle {

    // extra fields/attributes of the PickupTruck subclass
    private String cargoBedType;
    private int cargoCapacity;

    // constructor for PickupTruck subclass
    public PickupTruck(long carID, String vehicleType, String subType, int speed, double fuel, int seats, int year, String driveTrain, int price, int quantity, String cargoBedType, int cargoCapacity) {
        super(carID, vehicleType, subType, speed, fuel, seats, year, driveTrain, price, quantity);
        this.cargoBedType = cargoBedType;
        this.cargoCapacity = cargoCapacity;
    }

    // extra getters/setters
    public String getCarboBedType() {
        return cargoBedType;
    }
    public void setCargoBedType(String cardoBedType) {
        this.cargoBedType = cargoBedType;
    }
    public int getCargoCapacity() {
        return cargoCapacity;
    }
    public void setCargoCapacity(int cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
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
        return "PickupTruck";
    }
}
