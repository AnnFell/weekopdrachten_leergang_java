package nl.duo.weekopdrachten.carcase.domain;

public class RaceCar extends Vehicle {
    @Override
    public void drive() {
        // invokes the drive from the superclass (which is Car::drive() in this case)
        super.drive();
        System.out.println("Driving racecar");
    }
}
