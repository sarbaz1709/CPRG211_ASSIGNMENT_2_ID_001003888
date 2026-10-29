package problemdomain;

public class Hatchback extends Vehicle {

    // extra field/attribute of the hatchback subclass
    private char hatchType;

    // constructor for HatchBack subclass
    public Hatchback(long carID, String vehicleType, String subType, int speed, double fuel, int seats, int year, String drivetrain, int price, int quantity, char hatchType) {
        super(carID, vehicleType, subType, speed, fuel, seats, year, drivetrain, price, quantity);
        this.hatchType = hatchType;
    }

    // extra getter/setter for HatchType
    public char getHatchType() {
        return hatchType;
    }
    public void setHatchType(char hatchType) {
        this.hatchType = hatchType;
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
    public void purchase(){
        System.out.println("Purchase made");
    }

    @Override
    public String toString() {
        return "Hatchback";
    }


}

