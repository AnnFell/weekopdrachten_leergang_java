package nl.duo.weekopdrachten.week01.diceRollingEnhanced;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class YahtzeeSpel {
    private ArrayList<Dobbelsteen> dobbelstenen = new ArrayList<>();
    private ArrayList<Speler> spelers = new ArrayList<>();


    public YahtzeeSpel() {
        System.out.println("****** Yahtzee! ******");
        System.out.println("Om het spel te stoppen: typ q in en druk op enter.");
        // TODO: maak speler aan
        Scanner spelerScanner = new Scanner(System.in);

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
        int[] filter = new int[5];
        Worp worp = new Worp();

        for (int i = 1; i <= 3; i++) {
            // TODO: stop als filter alles blokkeert
            for (int j = 0; j < dobbelstenen.size(); j++) {
                if (filter[j] == 0) {
                    dobbelstenen.get(j).werpen();

                    // TODO: vraag, is dit beter dan Worp zelf kennis te geven van dobbelstenen?
                    worp.setUitslagPerDobbelsteen(j, dobbelstenen.get(j).getWaarde());
                }
            }
            printWorp(i);

            if (i != 3) {
                filter = vasthouden();
            }
        }
        // TODO: verplaats print methode naar worp
        // TODO: einde beurt afhandelen
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
