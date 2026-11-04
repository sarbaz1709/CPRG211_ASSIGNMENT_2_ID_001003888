/*
 * Author: Sarbaz Khan
 * Course: CPRG211 - Assignment 2: Abstract Class and Inheritance
 * Date: November 2026
 * Description: PickupTruck subclass of Vehicle (car ID starts with 6).
 *              Adds the cargo bed type (SB, EB or DB) and cargo capacity attributes.
 */
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
    public String getCargoBedType() {
        return cargoBedType;
    }
    public void setCargoBedType(String cargoBedType) {
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
    public String toString() { // note to self: even though toString must return a string and some of these fields being returned are not strings
                               // they (non-strings) get turned into strings automatically by being concatenated with strings
                               // (example: carID by itself it will say you are returning a long or something not string)
        // turn the cargo bed code into its full name for display (Strings are compared with .equals, not ==)
        String cargoBedTypeName;
        if (getCargoBedType().equals("SB")) {
            cargoBedTypeName = "Short Bed";
        } else if (getCargoBedType().equals("EB")) {
            cargoBedTypeName = "Extended Bed";
        } else if (getCargoBedType().equals("DB")) {
            cargoBedTypeName = "Dump Bed";
        } else {
            cargoBedTypeName = "Unknown";
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
                "\nCargo Capacity:\t" + getCargoCapacity() +
                "\nCargo Bed Type:\t" + cargoBedTypeName;
    }

    // overriding the formatForFile method in parent class to get the extra fields
    @Override
    public String formatForFile() {
        return super.formatForFile() + ";" + getCargoBedType() + ";" + getCargoCapacity();
    }

}
