package nl.duo.weekopdrachten.week01.diceRollingEnhanced;

import java.util.ArrayList;

public class Speler {
    String naam;
    ArrayList<Worp> worpGeschiedenis = new ArrayList<>();

    public Speler(String naam) {
        this.naam = naam;
    }

    public void voegWorpToe(Worp worp) {
        worpGeschiedenis.add(worp);
    }
}
