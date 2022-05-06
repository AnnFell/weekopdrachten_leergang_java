package nl.duo.weekopdrachten.diceRollingEnhanced;

public class Dobbelsteen {
    int waarde;

    public int werpen() {
        return (int) ((Math.random() * 6) + 1);
    }

    public int getWaarde() {
        return waarde;
    }
}
