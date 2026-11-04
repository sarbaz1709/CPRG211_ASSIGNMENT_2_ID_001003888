/*
 * Author: Sarbaz Khan
 * Course: CPRG211 - Assignment 2: Abstract Class and Inheritance
 * Date: November 2026
 * Description: Hybrid subclass of Vehicle (car ID starts with 4 or 5).
 *              Adds the powertrain (E, A or PHEV) and electric range attributes.
 */
package problemdomain;

public class Hybrid extends Vehicle {

    // extra fields/attributes for Hybrid subclass
    private String powerTrain;
    private int electricRange;

    // constructor for Hybrid subclass
    public Hybrid(long carID, String vehicleType, String subType, int speed, double fuel, int seats, int year, String driveTrain, int price, int quantity, String powerTrain, int electricRange) {
        super(carID, vehicleType, subType, speed, fuel, seats, year, driveTrain, price, quantity);
        this.powerTrain = powerTrain;
        this.electricRange = electricRange;
    }

    // extra getters/setters
    public String getPowerTrain() {
        return powerTrain;
    }
    public void setPowerTrain(String powerTrain) {
        this.powerTrain = powerTrain;
    }
    public int getElectricRange() {
        return electricRange;
    }
    public void setElectricRange(int electricRange) {
        this.electricRange = electricRange;
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
        setQuantity(getQuantity() - 1);
    }

    @Override
    public String toString() {
        // turn the powertrain code into its full name for display (Strings are compared with .equals, not ==)
        String powerTrainName;
        if (getPowerTrain().equals("E")) {
            powerTrainName = "Series Hybrid";
        } else if (getPowerTrain().equals("A")) {
            powerTrainName = "Parallel Hybrid";
        } else if (getPowerTrain().equals("PHEV")) {
            powerTrainName = "Plug-in Hybrid";
        } else {
            powerTrainName = "Unknown";
        }

        return "Car ID:\t\t" + getCarID() +
                "\nVehicle Type:\t" + getVehicleType() +
                "\nSub Type:\t" + getSubType() +
                "\nSpeed:\t\t" + getSpeed() +
                "\nFuel:\t\t" + getFuel() +
                "\nNumber of Seats:\t" + getSeats() +
                "\nYear:\t\t" + getYear() +
                "\nDrivetrain:\t\t" + getDriveTrain() +
                "\nPrice:\t\t" + getPrice() +
                "\nAvailable:\t\t" + getQuantity() +
                "\nPowertrain:\t" + powerTrainName +
                "\nElectric Range:\t" + getElectricRange();
    }

    @Override
    public String formatForFile() {
        return super.formatForFile() + ";" + getPowerTrain() + ";" + getElectricRange();
    }

}

