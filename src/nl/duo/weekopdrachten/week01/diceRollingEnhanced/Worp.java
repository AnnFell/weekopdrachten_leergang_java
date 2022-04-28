package nl.duo.weekopdrachten.week01.diceRollingEnhanced;

import java.util.Arrays;

public class Worp {
    private int[] uitslag = new int[5];

    public Worp() {
        System.out.println("Nieuwe worp gemaakt. Is nu: " + Arrays.toString(uitslag));
    }

    public void setUitslagPerDobbelsteen(int index, int waarde) {
        uitslag[index] = waarde;
    }

    public void geefUitslag() {
    }
}
