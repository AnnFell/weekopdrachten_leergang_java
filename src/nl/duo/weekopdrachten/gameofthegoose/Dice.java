package nl.duo.weekopdrachten.gameofthegoose;

public class Dice {
    public int throwDice() {
        int numberOfEyes = 6;
        return (int) (Math.random() * numberOfEyes) + 1;
    }
}
