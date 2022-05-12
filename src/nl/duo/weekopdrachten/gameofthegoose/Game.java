package nl.duo.weekopdrachten.gameofthegoose;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    Board board;
    List<Player> players;
    Scanner scanner;
    View view;
    Dice dice;
    int round;
    boolean finishReached;

    public Game() {
        board = new Board();
        players = new ArrayList<>();
        scanner = new Scanner(System.in);
        dice = new Dice();

        // create view
        view = new View(scanner);
        view.welcome();

        // create players
        int numberOfPlayers = view.askNumberOfPlayers();
        for (int i = 1; i <= numberOfPlayers; i++) {
            String playerName = view.askPlayerName(i);
            players.add(new Player(playerName));
        }

        // start game
        round();
    }

    private void round() {
        this.round++;
        // Every player gets to throw
        for (Player player : players) {
            turn(player);
        }

        // show progress
        for (Player player : players) {
            String boardProgress = board.giveBoardGraphic(player.getPosition());
            view.printProgressOfPlayer(boardProgress);
        }

        if (finishReached) {
            // end the game
            System.out.println("End of game");
            System.exit(0);
        } else {
            // start new round
            round();
        }
    }

    private void turn(Player player) {
        int diceResult = throwDice(player);
        boolean playerReachedFinish = board.doesPlayerReachFinish(player.getPosition(), diceResult);

        if (playerReachedFinish) {
            view.declareWinner(player.getName());
            finishReached = true;
        } else {
            int newPosition = board.getNewPosition(player.getPosition(), diceResult);
            player.setPosition(newPosition);
        }
    }

    private int throwDice(Player player) {
        view.askPlayerToThrow(player.getName());
        return dice.throwDice();
    }

}
