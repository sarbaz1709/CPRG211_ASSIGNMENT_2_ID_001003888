package problemdomain;

public class Hybrid extends Vehicle {

    // extra fields/attributes for SUV subclass
    private String PowerTrain;
    private int ElectricRange;

    // constructor for SUV subclass
    public Hybrid (long carID, String vehicleType, String subType, int speed, double fuel, int seats, int year, String drivetrain, int price, int quantity, String PowerTrain, int ElectricRange) {
        super(carID, vehicleType, subType, speed, fuel, seats, year, drivetrain, price, quantity);
        this.PowerTrain = PowerTrain;
        this.ElectricRange = ElectricRange;
    }

    // extra getter/setter
    public String getPowerTrain() {
        return PowerTrain;
    }
    public void setPowerTrain() {
        this.PowerTrain = PowerTrain;
    }
    public int getElectricRange() {
        return ElectricRange;
    }
    public void setElectricRange(int ElectricRange) {
        this.ElectricRange = ElectricRange;
    }

    // override the 3 abstract Vehicle methods
    @Override
    public boolean isAvailable(){
        if (getQuantity() > 0 ) {
            return true;
        } else return false;
    }

    @Override
    public void purchase() {
        System.out.println("Purchase made");
    }

    @Override
    public String toString() {
        return "";
    }

}

