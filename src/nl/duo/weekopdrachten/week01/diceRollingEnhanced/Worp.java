package nl.duo.weekopdrachten.week01.diceRollingEnhanced;

public class Worp {
    private int[] uitslag = new int[5];
    private String naamSpeler;

    public Worp(String naamSpeler) {
        this.naamSpeler = naamSpeler;
        System.out.println("*** Beurt van " + naamSpeler + ": ***");
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
