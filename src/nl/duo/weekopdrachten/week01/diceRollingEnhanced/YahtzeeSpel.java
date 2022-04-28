package nl.duo.weekopdrachten.week01.diceRollingEnhanced;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class YahtzeeSpel {
    private ArrayList<Dobbelsteen> dobbelstenen = new ArrayList<>();
    private Speler speler1;
//    private Speler speler2;


    public YahtzeeSpel() {
        // TODO: vraag: scanner.close geeft foutmelding?
        // Maar dobbelstenen aan
        for (int i = 0; i < 5; i++) {
            Dobbelsteen steen = new Dobbelsteen();
            dobbelstenen.add(steen);
        }

        System.out.println("****** Yahtzee! ******");
        System.out.println("Om het spel te stoppen: typ q in en druk op enter.");

        // Maak spelers aan
        Scanner spelerScanner = new Scanner(System.in);
        System.out.println("Wat is de naam van de eerste speler? Typ deze in en druk op enter.");
        String naamSpeler1 = spelerScanner.nextLine();
        speler1 = new Speler(naamSpeler1);
        System.out.println("Bedankt. Speler 1 heet: " + naamSpeler1);
//        System.out.println("Wat is de naam van de tweede speler? Typ deze in en druk op enter.");
//        String naamSpeler2 = spelerScanner.nextLine();
//        System.out.println("Bedankt. Speler 2 heet: " + naamSpeler1);
//        speler2 = new Speler(naamSpeler2);

        System.out.println("Druk op enter om het spel te starten");
        System.out.println("____________________________________");
    }

    public void spelen() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // Refactor scanner en reader tot 1
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
                    int uitslag = dobbelstenen.get(j).getWaarde();
                    worp.setUitslagPerDobbelsteen(j, uitslag);
                }
            }
            worp.geefUitslag(i);

            if (i != 3) {
                filter = vasthouden();
            }
        }
        System.out.println("Dit is het einde van je beurt. Je laatste worp wordt bewaard.");
        speler1.voegWorpToe(worp);
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
