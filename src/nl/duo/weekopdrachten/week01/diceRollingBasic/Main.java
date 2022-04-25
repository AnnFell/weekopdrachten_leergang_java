package nl.duo.weekopdrachten.week01.diceRollingBasic;

public class Main {

    public static void main(String[] args) {

        Dice steen = new Dice();
        System.out.println("Rolling the dice...");

        int totals = 0;
        for (int i = 0; i < 3; i++) {
            int roll = steen.roll();
            totals += roll;
            System.out.println("Result: " + roll);
        }
        System.out.println("Total of all rolls is: " + totals);
    }
}
