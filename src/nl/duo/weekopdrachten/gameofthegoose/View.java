package nl.duo.weekopdrachten.gameofthegoose;

import java.util.Scanner;

public class View {
    Scanner scanner;

    public View(Scanner scanner) {
        this.scanner = scanner;
    }

    public void welcome() {
        System.out.printf("%s%n%s%n%s%n",
                "*************************",
                "*** GAME OF THE GOOSE ***",
                "*************************"
        );
    }

    public int askNumberOfPlayers() {
        System.out.println("How many players? Type in a number, for example: 2, and press enter.");
        return Integer.parseInt(scanner.nextLine());
    }

    public String askPlayerName(int playerNumber) {
        System.out.println("What is the name of player " + playerNumber + "?");
        return scanner.nextLine();
    }

    public boolean askPlayerToThrow(String playerName) {
        System.out.println(playerName + ", please press enter to throw the dice!");
        if ("".equals(scanner.nextLine())) {
            return true;
        } else {
            return askPlayerToThrow(playerName);
        }
    }

    public void printProgressOfPlayer(String boardString) {
        System.out.println(boardString);
    }

    public void declareWinner(String playerName) {
        System.out.printf("%s reached the finish! %s won!%n", playerName, playerName);
    }
}
