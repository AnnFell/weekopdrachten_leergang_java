package nl.duo.weekopdrachten.miniweekopdrachten.opdr9;

public class Leeuw implements Vliegend{
    @Override
    public boolean kanVliegen() {
        return false;
    }

    @Override
    public String geefType() {
        return "Leeuw";
    }
}
