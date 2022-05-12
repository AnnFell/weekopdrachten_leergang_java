package nl.duo.weekopdrachten.carcase.domain;

import java.time.LocalDate;

public class Car extends Vehicle {
    private int speed;
    private double price;
    private final String licencePlate;

    private LocalDate registrationDate;

    public Car(String licencePlate) {
        this(licencePlate, -1);
    }

    public Car(String licencePlate, double price) {
        // hier wordt impliciet de super() aangeroepen
        this.licencePlate = licencePlate.toUpperCase();
        this.price = price;
        registrationDate = LocalDate.now();
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

//    public void setLicencePlate(String licencePlate) {
//        this.licencePlate = licencePlate;
//    }

    @Override
    public String toString() {
        return String.format("Plates: %s, price: %.2f", getLicencePlate(), getPrice());
    }

    public int getMileage() {
        return super.mileage;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getFuelLevel() {
        return "" + super.petrolTank.getCurrentLevel() + " of " + super.petrolTank.getMaxLevel();

    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Car) {
            Car myCar = (Car) o;
            return myCar.getLicencePlate().equals(this.getLicencePlate());
        } else {
            return false;
        }
    }

    @Override
    public void drive() {
        // invokes the drive from the superclass (which is Car::drive() in this case)
        super.drive();
//        System.out.println("Driving Car");
    }
}
