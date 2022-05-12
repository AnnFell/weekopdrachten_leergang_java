package nl.duo.weekopdrachten.carcase.domain;

public class TankOverfillException extends Exception {
    public TankOverfillException() {
        super("Tank is full, stop the pump!");
    }

}
