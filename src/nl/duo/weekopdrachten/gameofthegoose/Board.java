package nl.duo.weekopdrachten.gameofthegoose;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    private static final int FINISH_POSITION = 63;
    private static final List<Integer> SPECIAL_POSITIONS = new ArrayList<>(Arrays.asList(6, 19, 31, 42, 52, 58, 63));
    String reset = "\u001b[0m";
    String bgRed = "\u001b[41;1m";
    String bgGreen = "\u001b[42m";

    public boolean doesPlayerReachFinish(int currentPosition, int diceScore) {
        return currentPosition + diceScore == FINISH_POSITION;
    }

    public int getNewPosition(int currentPosition, int diceScore) {
        return currentPosition + diceScore;
        // create switch
        /*
         *         6, brug, Ga verder naar 12
         *
         *         19, herberg, Een beurt overslaan
         *
         *         31, put, Wie hier komt moet er blijven tot een andere speler er komt.Degene die er het eerst was speelt dan
         *         verder.
         *
         *         42, doolhof, Terug naar 39
         *
         *         52, gevangenis, drie beurten overslaan
         *
         *         58, dood, Terug naar begin, opnieuw beginnen
         *
         *         63, einde, Wie hier als eerste komt heeft gewonnen
         */
    }

    public String giveBoardGraphic(int playerPosition) {
        StringBuilder board = new StringBuilder();
        for (int i = 1; i <= FINISH_POSITION; i++) {
            String spaceFiller = i == playerPosition ? "X" : "_";
            if (SPECIAL_POSITIONS.contains(i)) {
                board.append(bgRed).append(spaceFiller).append(reset).append("|");
            } else {
                board.append(spaceFiller).append("|");
            }
        }
        return board.toString();
    }
}
