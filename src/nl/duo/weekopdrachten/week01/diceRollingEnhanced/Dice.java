package nl.duo.weekopdrachten.week01.diceRollingEnhanced;

public class Dice {

    /**
     * Give a roll of the dice
     * @return int between 1 and 6
     */
    public int roll(){
        return (int) (Math.random()*6)+1;
    }
}
