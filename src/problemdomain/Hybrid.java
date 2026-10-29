package problemdomain;

public class Hybrid extends Vehicle {

    // extra fields/attributes for SUV subclass
    private String powerTrain;
    private int electricRange;

    // constructor for SUV subclass
    public Hybrid (long carID, String vehicleType, String subType, int speed, double fuel, int seats, int year, String driveTrain, int price, int quantity, String powerTrain, int electricRange) {
        super(carID, vehicleType, subType, speed, fuel, seats, year, driveTrain, price, quantity);
        this.powerTrain = powerTrain;
        this.electricRange = electricRange;
    }

    // extra getters/setters
    public String getPowerTrain() {
        return powerTrain;
    }
    public void setPowerTrain() {
        this.powerTrain = powerTrain;
    }
    public int getElectricRange() {
        return electricRange;
    }
    public void setElectricRange(int ElectricRange) {
        this.electricRange = ElectricRange;
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
        return "Hybrid";
    }

}

