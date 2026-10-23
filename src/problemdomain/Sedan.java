package problemdomain;

public class Sedan extends Vehicle {

    // extra field/attribute of the Sedan subclass
    private char TrunkSize;

    // constructor for Sedan class
    public Sedan (long carID, String VehicleType, String subType, int speed, double fuel, int seats, int year, String drivetrain, int price, int quantity, char TrunkSize) {
        super (carID, VehicleType, subType, speed, fuel, seats, year, drivetrain, price, quantity);
        this.TrunkSize = TrunkSize;
    }

    // extra getter/setter for TrunkSize
    public char getTrunkSize(){
        return TrunkSize;
    }
    public void setTrunkSize(char TrunkSize) {
        this.TrunkSize = TrunkSize;
    }

    // override the 3 abstract Vehicle methods
    @Override
    public boolean isAvailable() {
        if (getQuantity() > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void purchase() {

    }

    @Override
    public String toString() {

    }
}
