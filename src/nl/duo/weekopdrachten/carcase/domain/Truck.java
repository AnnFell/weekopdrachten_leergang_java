package nl.duo.weekopdrachten.carcase.domain;

public class Truck extends Vehicle {
    String licencePlate;
    int weight;

    public Truck() {
        super(2, 100);
        this.weight = 8000;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public void drive() {
        // invokes the drive from the superclass (which is Car::drive() in this case)
        super.drive();
        System.out.println("Driving truck");
    }


}
