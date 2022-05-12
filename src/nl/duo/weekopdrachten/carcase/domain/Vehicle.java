package nl.duo.weekopdrachten.carcase.domain;

import java.time.LocalDate;

public abstract class Vehicle {
    protected PetrolTank petrolTank;
    protected int mileage;

    public Vehicle() {
        this(50,1);
    }

    public Vehicle(int maxLevelPetrol, int minLevelPetrol){
        petrolTank = new PetrolTank(maxLevelPetrol, minLevelPetrol);
    }


    public void fill(int liters){
        while (liters > 0) {
            try {
                petrolTank.fill();
                liters--;
            } catch (TankOverfillException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void drive() {
        if (petrolTank.getCurrentLevel() > petrolTank.getMinLevel()) {
            petrolTank.decrease(1);
        }
        mileage++;
    }

    public void drive(int kms) {
        while (kms > 0) {
            drive();
            kms--;
        }
    }

}
