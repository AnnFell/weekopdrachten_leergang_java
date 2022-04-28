package nl.duo.weekopdrachten.week01.diceRollingEnhanced;

import java.util.ArrayList;
import java.util.Scanner;

public class YahtzeeSpel {
    private ArrayList<Dobbelsteen> dobbelstenen = new ArrayList<>();
    private Scanner spelScanner;
    private Speler speler1;


    public YahtzeeSpel() {
        // Maak dobbelstenen aan
        for (int i = 0; i < 5; i++) {
            Dobbelsteen steen = new Dobbelsteen();
            dobbelstenen.add(steen);
        }
        // Start input scanner
        spelScanner = new Scanner(System.in);

        // Maak spelers aan
        System.out.println("****** Yahtzee! ******");
        System.out.println("Wat is de naam van de eerste speler? Typ deze in en druk op enter.");
        String naamSpeler1 = spelScanner.nextLine();
        speler1 = new Speler(naamSpeler1);
        System.out.println("Bedankt. Speler 1 heet: " + naamSpeler1);
    }

    public void spelen() {
        System.out.println("Druk op enter om het spel te starten");
        String key = spelScanner.nextLine();

        boolean qPress = false;

        if (key.equals("")) {
            System.out.println("____________________________________");
            System.out.println("Het spel is gestart. Om het spel te stoppen: typ q in en druk op enter.");
            System.out.println("");
            while (!qPress) {
                String isKeyPressed = spelScanner.nextLine();
                if (isKeyPressed.equalsIgnoreCase("q")) {
                    System.out.println("Het spel sluit af! Bedankt voor het spelen.");
                    qPress = true;
                } else if (isKeyPressed.equals("")) {
                    // TODO: welke speler start?
                    worp();
                }
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
        System.out.println("Welke posities wilt u vasthouden? 0 voor geen, anders bv 124.");
        String input = spelScanner.nextLine();
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
