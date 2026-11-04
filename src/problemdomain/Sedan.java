/*
 * File: Sedan.java
 * Author: Sarbaz Khan
 * Course: CPRG211 - Assignment 2: Abstract Class and Inheritance
 * Date: November 2026
 * Description: Sedan subclass of Vehicle (car ID starts with 1).
 *              Adds the trunk size attribute (L, S or M).
 */
package problemdomain;

public class Sedan extends Vehicle {

    // extra field/attribute of the Sedan subclass
    private char trunkSize;

    // constructor for Sedan subclass
    public Sedan(long carID, String vehicleType, String subType, int speed, double fuel, int seats, int year, String drivetrain, int price, int quantity, char trunkSize) {
        super(carID, vehicleType, subType, speed, fuel, seats, year, drivetrain, price, quantity);
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
        setQuantity(getQuantity() - 1);
    }

    @Override
    public String toString() {
        // turn the trunk size letter into its full name for display
        String trunkSizeName;
        if (getTrunkSize() == 'L') {
            trunkSizeName = "Large/spacious Trunk";
        } else if (getTrunkSize() == 'M') {
            trunkSizeName = "Moderate Trunk";
        } else if (getTrunkSize() == 'S') {
            trunkSizeName = "Small Trunk";
        } else {
            trunkSizeName = "Unknown";
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
                "\nTrunk Size:\t" + trunkSizeName;
    }

    @Override
    public String formatForFile() {
        return super.formatForFile() + ";" + getTrunkSize();
    }
}



