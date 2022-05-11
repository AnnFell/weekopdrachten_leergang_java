package nl.duo.weekopdrachten.miniweekopdrachten.opdr9;

public class Vliegtuig implements Vliegend {

    @Override
    public boolean kanVliegen() {
        return true;
    }

    @Override
    public String geefType() {
        return "Vliegtuig";
    }
}
