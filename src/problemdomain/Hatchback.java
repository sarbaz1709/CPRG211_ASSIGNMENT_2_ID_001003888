/*
 * Author: Sarbaz Khan
 * Course: CPRG211 - Assignment 2: Abstract Class and Inheritance
 * Date: November 2026
 * Description: Hatchback subclass of Vehicle (car ID starts with 2).
 *              Adds the hatch type attribute (S, T or P).
 */
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
    public void purchase() {
        setQuantity(getQuantity() - 1);
    }

    @Override
    public String toString() {
        // turn the hatch type letter into its full name for display
        String hatchTypeName;
        if (getHatchType() == 'S') {
            hatchTypeName = "Standard Liftgate";
        } else if (getHatchType() == 'T') {
            hatchTypeName = "Split Liftgate";
        } else if (getHatchType() == 'P') {
            hatchTypeName = "Power Liftgate";
        } else {
            hatchTypeName = "Unknown";
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
                "\nHatch Type:\t" + hatchTypeName;
    }

    @Override
    public String formatForFile() {
        return super.formatForFile() + ";" + getHatchType();
    }

}

