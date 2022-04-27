package nl.duo.weekopdrachten.week01.diceRollingEnhanced;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class YahtzeeSpel {
    private ArrayList<Dobbelsteen> dobbelstenen = new ArrayList<>();

    public YahtzeeSpel() {
        System.out.println("****** Yahtzee! ******");
        System.out.println("Om het spel te stoppen: typ q in en druk op enter.");
        System.out.println("Druk op enter om de dobbelstenen te gooien");
        System.out.println("____________________________________");
        for (int i = 0; i < 5; i++) {
            Dobbelsteen steen = new Dobbelsteen();
            dobbelstenen.add(steen);
        }
    }

    public void spelen() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        boolean qPress = false;
        while (!qPress) {
            String isKeyPressed = reader.readLine();
            if (isKeyPressed.equals("q")) {
                System.out.println("Het spel sluit af! Bedankt voor het spelen.");
                qPress = true;
            } else if (isKeyPressed.equals("")) {
                worp();
            }
        }
    }

    private void worp() {
        int worpTeller = 1;
        for (Dobbelsteen steen : dobbelstenen) {
            steen.werpen();
        }
        printWorp(worpTeller);
        worpTeller++;

        int[] filter = vasthouden();

        // opnieuw werpen met filter
        for (int i = 0; i < dobbelstenen.size(); i++) {
            if (filter[i] == 0) {
                dobbelstenen.get(i).werpen();
            }
        }
        printWorp(worpTeller);
    }

    private void printWorp(int worpTeller) {
        System.out.print("WORP" + worpTeller + ": ");
        for (Dobbelsteen steen : dobbelstenen) {
            System.out.print(steen.getWaarde() + " ");
        }
        System.out.println();
    }

    private int[] vasthouden() {
        int[] blokkeerArray = new int[5];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welke posities wilt u vasthouden? 0 voor geen, anders bv 124.");

        String input = scanner.nextLine();
        System.out.println("Invoer: " + input);

        if (!input.equals("0")) {
            for (int i = 0; i < input.length(); i++) {
                int index = Character.getNumericValue(input.charAt(i));
                blokkeerArray[index - 1] = 1;
            }
        }
        return blokkeerArray;
    }
}
