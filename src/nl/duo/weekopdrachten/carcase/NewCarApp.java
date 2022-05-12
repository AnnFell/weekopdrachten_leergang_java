package nl.duo.weekopdrachten.carcase;

import nl.duo.weekopdrachten.carcase.domain.*;

import java.util.ArrayList;
import java.util.List;

public class NewCarApp {
    public static void main(String[] args) {

        Vehicle car = new Car("ps494s");
        Vehicle racer = new RaceCar();
        Vehicle trucky = new Truck();

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(car);
        vehicles.add(racer);
        vehicles.add(trucky);

        carInspector(vehicles);
    }

    public static void carInspector(List<Vehicle> vehicles) {

        // try to invoke the getWeight method of the Truck using the instanceof keyword

        for (Vehicle v : vehicles) {
            if (v instanceof Truck) {
                Truck truck = (Truck) v;
                System.out.println(truck.getWeight());
            }
        }
    }
}
