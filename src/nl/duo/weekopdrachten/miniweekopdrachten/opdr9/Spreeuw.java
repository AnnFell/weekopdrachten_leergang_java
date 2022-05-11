package nl.duo.weekopdrachten.miniweekopdrachten.opdr9;

public class Spreeuw implements Vliegend {
    @Override
    public boolean kanVliegen() {
        return true;
    }

    @Override
    public String geefType() {
        return "Spreeuw";
    }
}
