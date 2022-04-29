package nl.duo.weekopdrachten.week01.diceRollingEnhanced;

import java.util.ArrayList;

public class Speler {
    String naam;
    YahtzeeKaart yahtzeeKaart = new YahtzeeKaart();

    public Speler(String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }

    public ArrayList<String> beschikbareOptiesVanSpeler(int[] worp) {
        return yahtzeeKaart.optiesVoorInvullen(worp);
    }

    public void vulKeuzeIn(String naamOptie, int[] worp) {
        yahtzeeKaart.vulKeuzeIn(naamOptie, worp);
    }
}
