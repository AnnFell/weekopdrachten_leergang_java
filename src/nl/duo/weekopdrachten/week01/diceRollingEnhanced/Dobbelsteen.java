package nl.duo.weekopdrachten.week01.diceRollingEnhanced;

public class Dobbelsteen {
    int waarde;

    public int werpen() {
        waarde = (int) ((Math.random() * 6) + 1);
        return waarde;
    }

    public int getWaarde() {
        return waarde;
    }
}
