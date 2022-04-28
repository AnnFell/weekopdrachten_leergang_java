package nl.duo.weekopdrachten.week01.diceRollingEnhanced;

import java.util.Arrays;

public class Worp {
    private int[] uitslag = new int[5];

    public Worp() {
        System.out.println("*** Start nieuwe beurt: ***");
    }

    public void setUitslagPerDobbelsteen(int index, int waarde) {
        uitslag[index] = waarde;
    }

    public void geefUitslag(int worpTeller) {
        System.out.print("WORP " + worpTeller + ": ");
        for (int score : uitslag) {
            System.out.print(score + " ");
        }
        System.out.println();
    }
}
