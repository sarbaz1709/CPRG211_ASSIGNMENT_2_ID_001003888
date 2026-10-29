package problemdomain;

public class Sedan extends Vehicle {

    // extra field/attribute of the Sedan subclass
    private char trunkSize;

    // constructor for Sedan subclass
    public Sedan (long carID, String vehicleType, String subType, int speed, double fuel, int seats, int year, String drivetrain, int price, int quantity, char trunkSize) {
        super (carID, vehicleType, subType, speed, fuel, seats, year, drivetrain, price, quantity);
        this.trunkSize = trunkSize;
    }

    // extra getter/setter for trunkSize
    public char getTrunkSize(){
        return trunkSize;
    }
    public void setTrunkSize(char trunkSize) {
        this.trunkSize = trunkSize;
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
        System.out.println("Purchase made");
    }

    @Override
    public String toString() {
        return "Sedan";
    }
}
