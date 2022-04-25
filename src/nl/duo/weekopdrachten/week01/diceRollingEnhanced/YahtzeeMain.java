package nl.duo.weekopdrachten.week01.diceRollingEnhanced;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

public class YahtzeeMain {
    public static void main(String[] args) throws IOException {
//        Does not work in IntelliJ :(
//        Console console = System.console();
//        if (console != null) {
//            String userInput = console.readLine();
//            console.writer().println("You entered the following: " + userInput);
//        } else {
//            throw new RuntimeException("Console not available");
//        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String userInput = reader.readLine();

        if (userInput.equals("")) {
            System.out.println("Enter key was pressed! Loop will start");
            boolean qPress = false;
            while (!qPress) {
                String isQPressed = reader.readLine();
                if (isQPressed.equals("q")) {
                    System.out.println("q is pressed! Loop wil quit");
                    qPress = true;
                }
            }
        }
    }
}
