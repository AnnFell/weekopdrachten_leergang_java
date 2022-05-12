package nl.duo.weekopdrachten.carcase;

import nl.duo.weekopdrachten.carcase.domain.Car;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class CarApp {
    public static void main(String[] args) {
        Car starlet = new Car("LH-SH-82");
        System.out.println(starlet); //prints memory name of class unless has .toString

        starlet.setPrice(25000.00);
//        starlet.setLicencePlate("LH-SH-62"); //should only be done in constructor

        System.out.println(starlet.toString());


        printCarStatus(starlet);
        starlet.fill(30);
        starlet.drive(3);
        printCarStatus(starlet);
        starlet.drive();
        starlet.fill(1);
        printCarStatus(starlet);

        // Exercise 8b
        List<Car> cars = new ArrayList<>();
        Car first = new Car("AA-BB-CC");
        cars.add(first);
        System.out.println("Is cars empty? " + cars.isEmpty());
        Car victim = new Car("AA-BB-CC");
        cars.remove(victim);
        System.out.println("Is cars empty? " + cars.isEmpty());
        // this returns true if you override .equals() to compare LicensePlate
        // instead of comparing the reference it points to

        // Exercise 12
        Car keepInGarage = new Car("666-AA-BB");
        LocalDate aCoupleOfYearsAgo = LocalDate.now().minusYears(100).minusMonths(1);
        keepInGarage.setRegistrationDate(aCoupleOfYearsAgo);
        printCarStatus(keepInGarage);
        Period periodBetweenNowAndCarRegistration = Period.between(LocalDate.now(), aCoupleOfYearsAgo);
        System.out.println("Period is: " + periodBetweenNowAndCarRegistration.toString());

    }

    private static void printCarStatus(Car car) {
        System.out.printf("Car: %s, mileage: %d, fuel level: %s, registrationDate: %s%n",
                car.getLicencePlate(),
                car.getMileage(),
                car.getFuelLevel(),
                car.getRegistrationDate()
        );
    }
}
