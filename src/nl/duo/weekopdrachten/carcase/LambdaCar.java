package nl.duo.weekopdrachten.carcase;

import nl.duo.weekopdrachten.carcase.domain.Car;
import nl.duo.weekopdrachten.carcase.domain.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaCar {
    public static void main(String[] args) {
        // Create some Cars
        // Create a List with Cars
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            String licencePlate = String.format("%02d-aa-bb", i);
            cars.add(new Car(licencePlate));
        }

        // Give the Cars some mileage
        for (Vehicle car : cars) {
            int amount = (int) (Math.random() * 30);
            car.fill(amount);
            car.drive(amount);
        }
        printCarList(cars);

        // Using the example code above get all cars in a list where their mileage is an even number
        List<Car> carsEvenMileage = cars.stream().filter((c -> c.getMileage() % 2 == 0)).collect(Collectors.toList());
        printCarList(carsEvenMileage);

        // Do the same but then for odd numbers
        List<Car> carsUnevenMileage = cars.stream().filter((c -> c.getMileage() % 2 != 0)).collect(Collectors.toList());
        printCarList(carsUnevenMileage);

        System.out.printf("To check if the filters worked -> total: %d, even: %d, uneven: %d%n",
                cars.size(), carsEvenMileage.size(), carsUnevenMileage.size());
    }

    private static void printCarList(List<Car> cars) {
        for (Car car : cars) {
            System.out.printf("Car %s: %d ", car.getLicencePlate(), car.getMileage());
        }
        System.out.println();
    }
}
