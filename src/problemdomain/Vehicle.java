/*
 * Author: Sarbaz Khan
 * Course: CPRG211 - Assignment 2: Abstract Class and Inheritance
 * Date: November 2026
 * Description: Abstract parent class for every vehicle type.
 *              Holds the attributes all vehicles share (car ID, type, sub type,
 *              speed, fuel, seats, year, drivetrain, price and quantity).
 *              It is abstract so it can't be created directly.
 */
package problemdomain;

public abstract class Vehicle {

    // fields/attributes of the abstract Vehicle class
    private long carID;
    private String vehicleType;
    private String subType;
    private int speed;
    private double fuel;
    private int seats;
    private int year;
    private String driveTrain;
    private int price;
    private int quantity;

    // constructor for Vehicle class that subclasses constructors will call using super
    public Vehicle(long carID, String vehicleType, String subType, int speed, double fuel, int seats, int year, String driveTrain, int price, int quantity) {
        this.carID = carID;
        this.vehicleType = vehicleType;
        this.subType = subType;
        this.speed = speed;
        this.fuel = fuel;
        this.seats = seats;
        this.year = year;
        this.driveTrain = driveTrain;
        this.price = price;
        this.quantity = quantity;
    }

    // getters and setters for the fields above
    public long getCarID() {
        return carID;
    }
    public void setCarID(long carID) {
        this.carID = carID;
    }
    public String getVehicleType() {
        return vehicleType;
    }
    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
    public String getSubType() {
        return subType;
    }
    public void setSubType(String subType){
        this.subType = subType;
    }
    public int getSpeed(){
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public double getFuel() {
        return fuel;
    }
    public void setFuel(double fuel) {
        this.fuel = fuel;
    }
    public int getSeats() {
        return seats;
    }
    public void setSeats(int seats) {
        this.seats = seats;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public String getDriveTrain() {
        return driveTrain;
    }
    public void setDriveTrain(String driveTrain) {
        this.driveTrain = driveTrain;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // abstract Vehicle methods (promises that say the subclass should have them)
    public abstract boolean isAvailable();
    public abstract void purchase();
    public abstract String toString();

    // formatForFile helper method which will format the file for the file reader to store it in vehicles.txt
    // each subclass overrides it and uses super.formatForFile() to add its extra fields
    public String formatForFile() {
        return getCarID() + ";" + getVehicleType() + ";" + getSubType() + ";" + getSpeed() + ";" + getFuel() + ";" + getSeats() + ";" + getYear() + ";" + getDriveTrain() + ";" + getPrice() + ";" + getQuantity();
    }
}
