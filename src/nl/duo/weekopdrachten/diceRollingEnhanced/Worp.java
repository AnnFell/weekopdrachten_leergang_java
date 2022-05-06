package nl.duo.weekopdrachten.diceRollingEnhanced;

public class Worp {
    private final int[] uitslag = new int[5];

    public Worp(String naamSpeler) {
        System.out.println("*** Beurt van " + naamSpeler + ": ***");
    }

    public void setUitslagPerDobbelsteen(int index, int waarde) {
        uitslag[index] = waarde;
    }

    public void printUitslag(int worpTeller) {
        System.out.print("WORP " + worpTeller + ": ");
        for (int score : uitslag) {
            System.out.print(score + " ");
        }
        System.out.println();
    }

    public int[] getUitslag() {
        return uitslag;
    }
}
